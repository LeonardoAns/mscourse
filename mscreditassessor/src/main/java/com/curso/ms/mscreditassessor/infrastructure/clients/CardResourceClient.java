package com.curso.ms.mscreditassessor.infrastructure.clients;

import com.curso.ms.mscreditassessor.core.entities.Card;
import com.curso.ms.mscreditassessor.core.entities.ClientCard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@FeignClient(value = "mscards", path = "/cards")
public interface CardResourceClient {

    @GetMapping(value = "/get-by-client", params = "cpf")
    ResponseEntity<List<ClientCard>> getCardsByClient(@RequestParam("cpf") String cpf);

    @GetMapping(value = "/get-by-income", params = "income")
    ResponseEntity<List<Card>> getCardsByIncome(@RequestParam("income") BigDecimal limit);
}
