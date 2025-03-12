package com.curso.ms.mscards.core.usecases.clientcard;

import com.curso.ms.mscards.presentation.dtos.clientcard.response.ClientCardResponseDto;

import java.util.List;

public interface GetCardsByClientUseCase {
    List<ClientCardResponseDto> execute(String cpf);
}
