package com.curso.ms.mscreditassessor.presentation.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApprovedCardsResponse {
    private String name;
    private String flag;
    private BigDecimal limit;
}
