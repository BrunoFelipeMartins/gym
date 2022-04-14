package com.academy.gym.services;

import com.academy.gym.repositories.AlunoRepository;

import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    final AlunoRepository AlunoRepository; 

    public AlunoService(AlunoRepository alunoRepository){
        this.AlunoRepository = alunoRepository;
    }
}
