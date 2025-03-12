package com.curso.ms.mscards.presentation.dtos.card.response;

import com.curso.ms.mscards.core.enums.CardFlag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardResponseDto {

    private Long id;
    private String name;
    private CardFlag cardFlag;
    private BigDecimal limit;
    private BigDecimal basicIncome;
}
