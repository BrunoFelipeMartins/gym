package com.academy.gym.repositories;

import java.util.UUID;

import com.academy.gym.models.Plano;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, UUID> {
    
}
