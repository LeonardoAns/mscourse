package com.curso.ms.mscreditassessor.infrastructure.clients;

import com.curso.ms.mscreditassessor.core.entities.ClientData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "msclients", path = "/clients")
public interface ClientResourceClient {

    @GetMapping(value = "/get", params = "cpf")
    ResponseEntity<ClientData> getClientByCpf(@RequestParam String cpf);
}
