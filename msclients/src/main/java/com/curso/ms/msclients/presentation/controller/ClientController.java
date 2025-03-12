package com.curso.ms.msclients.presentation.controller;

import com.curso.ms.msclients.core.usecases.GetClientByCpfUseCase;
import com.curso.ms.msclients.core.usecases.RegisterClientUseCase;
import com.curso.ms.msclients.presentation.dtos.request.ClientRequestDto;
import com.curso.ms.msclients.presentation.dtos.response.ClientResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
@Slf4j
public class ClientController {

    private final RegisterClientUseCase registerClientUseCase;
    private final GetClientByCpfUseCase getClientByCpfUseCase;

    @GetMapping("/status")
    public String getAll() {
        log.info("Obtendo status do microservice de clientes");
        return "OK";
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerClient(@RequestBody ClientRequestDto clientRequest) {
        this.registerClientUseCase.execute(clientRequest);
        URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequest().query("cpf={cpf}").buildAndExpand(clientRequest.getCpf()).toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(value = "/get", params = "cpf")
    public ResponseEntity<ClientResponseDto> getClientByCpf(@RequestParam String cpf) {
        ClientResponseDto clientResponseDto = this.getClientByCpfUseCase.execute(cpf);
        return ResponseEntity.ok(clientResponseDto);
    }


}
