package com.curso.ms.mscreditassessor.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientData {

    private Long id;
    private String name;
    private Integer age;
}
