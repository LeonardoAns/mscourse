package com.curso.ms.mscards.presentation.dtos.card.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardIssuanceData {

    private Long cardId;
    private String cpf;
    private String address;
    private BigDecimal approvedLimit;
}
