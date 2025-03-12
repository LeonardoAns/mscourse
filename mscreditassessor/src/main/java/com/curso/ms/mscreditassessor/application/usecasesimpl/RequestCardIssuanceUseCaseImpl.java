package com.curso.ms.mscreditassessor.application.usecasesimpl;

import com.curso.ms.mscreditassessor.application.exception.base.InternalServerException;
import com.curso.ms.mscreditassessor.core.usecases.RequestCardIssuanceUseCase;
import com.curso.ms.mscreditassessor.infrastructure.mqueue.CardIssuanceRequest;
import com.curso.ms.mscreditassessor.presentation.dtos.request.CardIssuanceData;
import com.curso.ms.mscreditassessor.presentation.dtos.response.CardIssuanceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RequestCardIssuanceUseCaseImpl implements RequestCardIssuanceUseCase {

    private final CardIssuanceRequest cardIssuanceRequest;

    @Override
    public CardIssuanceResponse execute(CardIssuanceData cardIssuanceData) {
        try{
            cardIssuanceRequest.requestCardIssuance(cardIssuanceData);
            return new CardIssuanceResponse(UUID.randomUUID().toString());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new InternalServerException("Error requesting card issuance");
        }
    }
}
