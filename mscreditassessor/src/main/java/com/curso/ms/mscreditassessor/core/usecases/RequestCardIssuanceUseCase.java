package com.curso.ms.mscreditassessor.core.usecases;

import com.curso.ms.mscreditassessor.presentation.dtos.request.CardIssuanceData;
import com.curso.ms.mscreditassessor.presentation.dtos.response.CardIssuanceResponse;

public interface RequestCardIssuanceUseCase {
    CardIssuanceResponse execute(CardIssuanceData cardIssuanceData);
}
