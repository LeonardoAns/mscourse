package com.curso.ms.mscards.core.entities;

import com.curso.ms.mscards.core.enums.CardFlag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private CardFlag cardFlag;
    private BigDecimal basicLimit;
    private BigDecimal income;

    public Card(String name, CardFlag cardFlag, BigDecimal limit, BigDecimal basicIncome) {
        this.name = name;
        this.cardFlag = cardFlag;
        this.basicLimit = limit;
        this.income = basicIncome;
    }
}
