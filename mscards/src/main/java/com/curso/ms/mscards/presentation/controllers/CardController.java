package com.curso.ms.mscards.presentation.controllers;

import com.curso.ms.mscards.core.entities.ClientCard;
import com.curso.ms.mscards.core.usecases.card.GetCardsByIncomeUseCase;
import com.curso.ms.mscards.core.usecases.card.RegisterCardUseCase;
import com.curso.ms.mscards.core.usecases.clientcard.GetCardsByClientUseCase;
import com.curso.ms.mscards.presentation.dtos.card.request.CardRequestDto;
import com.curso.ms.mscards.presentation.dtos.card.response.CardResponseDto;
import com.curso.ms.mscards.presentation.dtos.clientcard.response.ClientCardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {

    private final RegisterCardUseCase registerCardUseCase;
    private final GetCardsByIncomeUseCase getCardsByLimitUseCase;
    private final GetCardsByClientUseCase getCardsByClientUseCase;

    @GetMapping("/status")
    public String status() {
        return "OK";
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerCard(@RequestBody CardRequestDto cardRequest) {
        System.out.println("da controller "+ cardRequest);
        this.registerCardUseCase.execute(cardRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/get-by-income", params = "income")
    public ResponseEntity<List<CardResponseDto>> getCardsByIncome(@RequestParam("income") BigDecimal limit) {
        List<CardResponseDto> cards = this.getCardsByLimitUseCase.execute(limit);
        return ResponseEntity.ok(cards);
    }

    @GetMapping(value = "/get-by-client", params = "cpf")
    public ResponseEntity<List<ClientCardResponseDto>> getCardsByClient(@RequestParam("cpf") String cpf) {
        List<ClientCardResponseDto> clientCards = this.getCardsByClientUseCase.execute(cpf);
        return ResponseEntity.ok(clientCards);
    }
}
