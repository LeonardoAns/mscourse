package com.curso.ms.mscards.core.usecases.card;

import com.curso.ms.mscards.presentation.dtos.card.response.CardResponseDto;

import java.math.BigDecimal;
import java.util.List;

public interface GetCardsByIncomeUseCase {
    List<CardResponseDto> execute(BigDecimal income);
}
