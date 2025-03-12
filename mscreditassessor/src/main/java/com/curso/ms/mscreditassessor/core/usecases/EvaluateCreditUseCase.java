package com.curso.ms.mscreditassessor.core.usecases;

import com.curso.ms.mscreditassessor.presentation.dtos.request.EvaluateData;
import com.curso.ms.mscreditassessor.presentation.dtos.response.ApprovedCardsResponse;
import com.curso.ms.mscreditassessor.presentation.dtos.response.EvaluateDataResponse;

public interface EvaluateCreditUseCase {
    EvaluateDataResponse execute(EvaluateData evaluateData);
}
