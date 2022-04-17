package com.academy.gym.services;

import com.academy.gym.repositories.ContaRepository;

import org.springframework.stereotype.Service;

@Service
public class ContaService {
    
    final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository){
        this.contaRepository = contaRepository;
    }
}
