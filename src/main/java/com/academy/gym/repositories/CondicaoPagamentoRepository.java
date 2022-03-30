package com.academy.gym.repositories;

import java.util.UUID;

import com.academy.gym.models.CondicaoPagamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondicaoPagamentoRepository extends JpaRepository<CondicaoPagamento, UUID> {
    
}
