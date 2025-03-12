package com.curso.ms.mscreditassessor.presentation.controller;

import com.curso.ms.mscreditassessor.application.usecasesimpl.GetClientSituationUseCaseImpl;
import com.curso.ms.mscreditassessor.application.usecasesimpl.RequestCardIssuanceUseCaseImpl;
import com.curso.ms.mscreditassessor.core.entities.ClientSituation;
import com.curso.ms.mscreditassessor.core.usecases.EvaluateCreditUseCase;
import com.curso.ms.mscreditassessor.core.usecases.GetClientSituationUseCase;
import com.curso.ms.mscreditassessor.core.usecases.RequestCardIssuanceUseCase;
import com.curso.ms.mscreditassessor.presentation.dtos.request.CardIssuanceData;
import com.curso.ms.mscreditassessor.presentation.dtos.request.EvaluateData;
import com.curso.ms.mscreditassessor.presentation.dtos.response.CardIssuanceResponse;
import com.curso.ms.mscreditassessor.presentation.dtos.response.EvaluateDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credit-assessor")
@RequiredArgsConstructor
public class CreditAssessorController {

    private final GetClientSituationUseCase getClientSituationUseCase;
    private final EvaluateCreditUseCase evaluateCreditUseCase;
    private final RequestCardIssuanceUseCase requestCardIssuanceUseCase;

    @GetMapping("/status")
    public String status(){
        return "OK";
    }

    @GetMapping(value = "/client-situation", params = "cpf")
    public ResponseEntity<ClientSituation> getClientSituation(@RequestParam("cpf") String cpf){
        ClientSituation clientSituation = this.getClientSituationUseCase.execute(cpf);
        return ResponseEntity.ok(clientSituation);
    }

    @PostMapping("/evaluate")
    public ResponseEntity<EvaluateDataResponse> evaluate(@RequestBody EvaluateData evaluateData){
        EvaluateDataResponse evaluateDataResponse = this.evaluateCreditUseCase.execute(evaluateData);
        return ResponseEntity.ok(evaluateDataResponse);
    }

    @PostMapping("/request-card")
    public ResponseEntity<CardIssuanceResponse> requestCard(@RequestBody CardIssuanceData cardIssuanceData){
        CardIssuanceResponse response = this.requestCardIssuanceUseCase.execute(cardIssuanceData);
        return ResponseEntity.ok(response);
    }
}
