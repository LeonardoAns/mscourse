package com.curso.ms.msclients.core.usecases;

import com.curso.ms.msclients.presentation.dtos.request.ClientRequestDto;

public interface RegisterClientUseCase {
    void execute(ClientRequestDto clientRequest);
}
