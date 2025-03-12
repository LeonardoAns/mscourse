package com.curso.ms.mscards.presentation.dtos.card.request;

import com.curso.ms.mscards.core.enums.CardFlag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardRequestDto {

    private String name;
    private CardFlag cardFlag;
    private BigDecimal basicLimit;
    private BigDecimal income;
}
