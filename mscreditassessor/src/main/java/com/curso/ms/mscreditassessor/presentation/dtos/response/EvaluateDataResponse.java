package com.curso.ms.mscreditassessor.presentation.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EvaluateDataResponse {
    List<ApprovedCardsResponse> approvedCards;
}
