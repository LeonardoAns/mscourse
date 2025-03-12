package com.curso.ms.mscreditassessor.application.usecasesimpl;

import com.curso.ms.mscreditassessor.application.exception.base.NotFoundException;
import com.curso.ms.mscreditassessor.application.exception.base.ServiceCommunicationException;
import com.curso.ms.mscreditassessor.core.entities.ClientCard;
import com.curso.ms.mscreditassessor.core.entities.ClientData;
import com.curso.ms.mscreditassessor.core.entities.ClientSituation;
import com.curso.ms.mscreditassessor.core.usecases.GetClientSituationUseCase;
import com.curso.ms.mscreditassessor.infrastructure.clients.CardResourceClient;
import com.curso.ms.mscreditassessor.infrastructure.clients.ClientResourceClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetClientSituationUseCaseImpl implements GetClientSituationUseCase {

    private final ClientResourceClient clientResourceClient;
    private final CardResourceClient cardResourceClient;

    @Override
    public ClientSituation execute(String cpf) {
        try {
            ResponseEntity<ClientData> clientData = this.clientResourceClient.getClientByCpf(cpf);
            ResponseEntity<List<ClientCard>> clientCard = this.cardResourceClient.getCardsByClient(cpf);
            return ClientSituation
                    .builder()
                    .clientData(clientData.getBody())
                    .cards(clientCard.getBody())
                    .build();
        }catch (FeignException.FeignClientException ex){
            throw new NotFoundException("Client Not Found");
        }
    }
}
