package com.curso.ms.mscreditassessor.presentation.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluateData {
    private String cpf;
    private BigDecimal income;
}
