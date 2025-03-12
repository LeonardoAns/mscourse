package com.curso.ms.mscards.core.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String address;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @Column(name = "credit_limit")
    private BigDecimal limit;

}
