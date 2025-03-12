package com.curso.ms.mscards.presentation.dtos.clientcard.response;

import com.curso.ms.mscards.core.entities.Card;
import com.curso.ms.mscards.core.enums.CardFlag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientCardResponseDto {

    private String nome;
    private CardFlag flag;
    private BigDecimal limit;

}
