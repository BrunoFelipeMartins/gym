package com.academy.gym.services;

import com.academy.gym.repositories.CaixaRepository;

import org.springframework.stereotype.Service;

@Service
public class CaixaService {
    final CaixaRepository caixaRepository;

    public CaixaService(CaixaRepository caixaRepository){
        this.caixaRepository = caixaRepository;
    }
}
