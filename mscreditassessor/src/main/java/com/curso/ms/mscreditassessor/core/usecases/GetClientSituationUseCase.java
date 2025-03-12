package com.curso.ms.mscreditassessor.core.usecases;

import com.curso.ms.mscreditassessor.core.entities.ClientSituation;

public interface GetClientSituationUseCase {

    ClientSituation execute(String cpf);
}
