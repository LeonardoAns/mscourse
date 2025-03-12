package com.curso.ms.mscards.infrastructure.repositories;

import com.curso.ms.mscards.core.entities.ClientCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientCardRepository extends JpaRepository<ClientCard, Long> {

    List<ClientCard> findClientCardByCpf(String cpf);
}
