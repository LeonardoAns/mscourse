package com.curso.ms.mscreditassessor.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientCard {

    private String name;
    private String flag;
    private BigDecimal limit;
}
