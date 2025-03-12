package com.curso.ms.mscards.application.usecasesimpl.card;

import com.curso.ms.mscards.core.entities.Card;
import com.curso.ms.mscards.core.usecases.card.GetCardsByIncomeUseCase;
import com.curso.ms.mscards.infrastructure.repositories.CardRepository;
import com.curso.ms.mscards.presentation.dtos.card.response.CardResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetCardsByIncomeUseCaseImpl implements GetCardsByIncomeUseCase {

    private final CardRepository cardRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CardResponseDto> execute(BigDecimal income) {
        List<Card> cards = this.cardRepository.findCardsByIncome(income);
        return cards
                .stream()
                .map(card ->
                        this.modelMapper.map(card, CardResponseDto.class))
                .toList();
    }
}
