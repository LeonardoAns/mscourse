package com.curso.ms.mscreditassessor.application.usecasesimpl;

import com.curso.ms.mscreditassessor.application.exception.base.NotFoundException;
import com.curso.ms.mscreditassessor.core.entities.Card;
import com.curso.ms.mscreditassessor.core.entities.ClientCard;
import com.curso.ms.mscreditassessor.core.entities.ClientData;
import com.curso.ms.mscreditassessor.core.entities.ClientSituation;
import com.curso.ms.mscreditassessor.core.usecases.EvaluateCreditUseCase;
import com.curso.ms.mscreditassessor.infrastructure.clients.CardResourceClient;
import com.curso.ms.mscreditassessor.infrastructure.clients.ClientResourceClient;
import com.curso.ms.mscreditassessor.presentation.dtos.request.EvaluateData;
import com.curso.ms.mscreditassessor.presentation.dtos.response.ApprovedCardsResponse;
import com.curso.ms.mscreditassessor.presentation.dtos.response.EvaluateDataResponse;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EvaluateCreditUseCaseImpl implements EvaluateCreditUseCase {

    private final ClientResourceClient clientResourceClient;
    private final CardResourceClient cardResourceClient;

    @Override
    public EvaluateDataResponse execute(EvaluateData evaluateData) {
        try {
            ClientData clientData = Optional.ofNullable(clientResourceClient.getClientByCpf(evaluateData.getCpf()))
                    .map(ResponseEntity::getBody)
                    .orElseThrow(() -> new NotFoundException("Client not found"));

            List<Card> cards = Optional.ofNullable(cardResourceClient.getCardsByIncome(evaluateData.getIncome()))
                    .map(ResponseEntity::getBody)
                    .orElseThrow(() -> new NotFoundException("No cards found for the given income"));

            List<ApprovedCardsResponse> approvedCards = cards.stream()
                    .map(card -> mapToApprovedCard(clientData, card))
                    .collect(Collectors.toList());

            return new EvaluateDataResponse(approvedCards);

        }catch (FeignException.FeignClientException ex) {
            throw new NotFoundException("Client Not Found");
        }
    }

    private ApprovedCardsResponse mapToApprovedCard(ClientData clientData, Card card) {
        BigDecimal limit = card.getLimit();
        BigDecimal ageFactor = BigDecimal.valueOf(clientData.getAge()).divide(BigDecimal.TEN);
        BigDecimal approvedLimit = ageFactor.multiply(limit);

        return new ApprovedCardsResponse(card.getName(), card.getFlag(), approvedLimit);
    }
}
