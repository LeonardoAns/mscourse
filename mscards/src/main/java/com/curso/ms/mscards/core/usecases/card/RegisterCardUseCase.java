package com.curso.ms.mscards.core.usecases.card;

import com.curso.ms.mscards.presentation.dtos.card.request.CardRequestDto;

public interface RegisterCardUseCase {
    void execute(CardRequestDto cardRequest);
}
