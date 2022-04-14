package com.academy.gym.repositories;

import java.util.Optional;
import java.util.UUID;

import com.academy.gym.models.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, UUID> {

    Optional<Aluno> findByCpf(String cpf);

}
