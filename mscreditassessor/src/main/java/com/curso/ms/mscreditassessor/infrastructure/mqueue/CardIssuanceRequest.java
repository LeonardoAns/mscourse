package com.curso.ms.mscreditassessor.infrastructure.mqueue;

import com.curso.ms.mscreditassessor.presentation.dtos.request.CardIssuanceData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardIssuanceRequest {
    
    private final RabbitTemplate rabbitTemplate;
    private final Queue cardIssuanceQueue;

    public void requestCardIssuance(CardIssuanceData cardIssuanceData) throws JsonProcessingException {
        String json = convertToJson(cardIssuanceData);
        this.rabbitTemplate.convertAndSend(this.cardIssuanceQueue.getName(), json);
    }

    private String convertToJson(CardIssuanceData data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
         return mapper.writeValueAsString(data);

    }
}
