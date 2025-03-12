package com.curso.ms.mscards.application.usecasesimpl.clientcard;

import com.curso.ms.mscards.core.entities.ClientCard;
import com.curso.ms.mscards.core.usecases.clientcard.GetCardsByClientUseCase;
import com.curso.ms.mscards.infrastructure.repositories.ClientCardRepository;
import com.curso.ms.mscards.presentation.dtos.clientcard.response.ClientCardResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetCardsByClientUseCaseImpl implements GetCardsByClientUseCase {

    private final ClientCardRepository clientCardRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ClientCardResponseDto> execute(String cpf) {
        List<ClientCard> clientCards = this.clientCardRepository.findClientCardByCpf(cpf);
        return clientCards
                .stream()
                .map(clientCard -> {
                    return new ClientCardResponseDto(
                            clientCard.getCard().getName(),
                            clientCard.getCard().getCardFlag(),
                            clientCard.getCard().getBasicLimit());
                })
                .toList();
    }
}
