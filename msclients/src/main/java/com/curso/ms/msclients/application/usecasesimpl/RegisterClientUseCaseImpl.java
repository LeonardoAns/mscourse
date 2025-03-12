package com.curso.ms.msclients.application.usecasesimpl;

import com.curso.ms.msclients.core.entities.Client;
import com.curso.ms.msclients.core.usecases.RegisterClientUseCase;
import com.curso.ms.msclients.infrastructure.repositories.ClientRepository;
import com.curso.ms.msclients.presentation.dtos.request.ClientRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RegisterClientUseCaseImpl implements RegisterClientUseCase {

    private final ClientRepository clientRepository;

    @Override
    public void execute(ClientRequestDto clientRequest) {
        Client client = Client.builder()
                .cpf(clientRequest.getCpf())
                .name(clientRequest.getName())
                .age(clientRequest.getAge())
                .build();

        this.clientRepository.save(client);
    }
}
