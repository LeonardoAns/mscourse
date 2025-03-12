package com.curso.ms.mscards.application.usecasesimpl.card;

import com.curso.ms.mscards.core.entities.Card;
import com.curso.ms.mscards.core.usecases.card.RegisterCardUseCase;
import com.curso.ms.mscards.infrastructure.repositories.CardRepository;
import com.curso.ms.mscards.presentation.dtos.card.request.CardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterCardUseCaseImpl implements RegisterCardUseCase {

    private final CardRepository cardRepository;

    @Override
    public void execute(CardRequestDto cardRequest) {
        System.out.println(cardRequest);
        Card card = Card
                .builder()
                .name(cardRequest.getName())
                .cardFlag(cardRequest.getCardFlag())
                .basicLimit(cardRequest.getBasicLimit())
                .income(cardRequest.getIncome())
                .build();

        System.out.println("==============");
        System.out.println(card);


        this.cardRepository.save(card);
    }
}
