package com.academy.gym.services;

import com.academy.gym.repositories.AlunoPlanoRepository;

import org.springframework.stereotype.Service;

@Service
public class AlunoPlanoService {

    final AlunoPlanoRepository alunoPlanoRepository;

    public AlunoPlanoService(AlunoPlanoRepository alunoPlanoRepository){
        this.alunoPlanoRepository = alunoPlanoRepository;
    }
    
}
