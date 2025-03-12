package com.curso.ms.mscards.infrastructure.mqueue;

import com.curso.ms.mscards.core.entities.Card;
import com.curso.ms.mscards.core.entities.ClientCard;
import com.curso.ms.mscards.infrastructure.repositories.CardRepository;
import com.curso.ms.mscards.infrastructure.repositories.ClientCardRepository;
import com.curso.ms.mscards.presentation.dtos.card.request.CardIssuanceData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardIssuanceSubscriber {

    private final CardRepository cardRepository;
    private final ClientCardRepository clientCardRepository;

    @RabbitListener(queues = "${mq.queues.card_issuance}")
    public void receiveIssuanceRequest(String payload){
        try {
            ObjectMapper mapper = new ObjectMapper();
            CardIssuanceData cardData = mapper.readValue(payload, CardIssuanceData.class);
            Card card = this.cardRepository.findById(cardData.getCardId())
                    .orElseThrow(() -> new NotFoundException("Card not found"));
            ClientCard clientCard = ClientCard
                    .builder()
                    .card(card)
                    .cpf(cardData.getCpf())
                    .limit(cardData.getApprovedLimit())
                    .address(cardData.getAddress())
                    .build();
            this.clientCardRepository.save(clientCard);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
