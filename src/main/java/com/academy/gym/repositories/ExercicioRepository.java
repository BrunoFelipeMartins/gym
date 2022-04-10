package com.academy.gym.repositories;

import java.util.UUID;

import com.academy.gym.models.Exercicio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, UUID> {
    
}
