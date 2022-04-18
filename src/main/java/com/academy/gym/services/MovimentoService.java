package com.academy.gym.services;

import com.academy.gym.repositories.MovimentoRepository;

import org.springframework.stereotype.Service;

@Service
public class MovimentoService {

    final MovimentoRepository movimentoRepository;
    
    public MovimentoService(MovimentoRepository movimentoRepository){
        this.movimentoRepository = movimentoRepository;
    }
}
