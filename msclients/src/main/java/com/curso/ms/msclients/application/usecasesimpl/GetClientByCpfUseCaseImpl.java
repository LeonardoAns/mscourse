package com.curso.ms.msclients.application.usecasesimpl;

import com.curso.ms.msclients.application.exception.base.NotFoundException;
import com.curso.ms.msclients.core.entities.Client;
import com.curso.ms.msclients.core.usecases.GetClientByCpfUseCase;
import com.curso.ms.msclients.infrastructure.repositories.ClientRepository;
import com.curso.ms.msclients.presentation.dtos.response.ClientResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetClientByCpfUseCaseImpl implements GetClientByCpfUseCase {

    private final ClientRepository clientRepository;


    @Override
    public ClientResponseDto execute(String cpf) {
        Client client = this.clientRepository.findByCpf(cpf)
                .orElseThrow(() -> new NotFoundException("Client Not Found"));

        return new ClientResponseDto(client.getId(), client.getCpf(), client.getName(), client.getAge());
    }
}
