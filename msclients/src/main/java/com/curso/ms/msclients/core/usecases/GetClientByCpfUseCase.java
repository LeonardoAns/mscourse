package com.curso.ms.msclients.core.usecases;

import com.curso.ms.msclients.presentation.dtos.response.ClientResponseDto;

public interface GetClientByCpfUseCase {
    ClientResponseDto execute(String cpf);
}
