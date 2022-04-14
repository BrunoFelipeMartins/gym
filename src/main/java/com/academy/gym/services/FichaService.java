package com.academy.gym.services;

import com.academy.gym.repositories.FichaRepository;

import org.springframework.stereotype.Service;

@Service
public class FichaService {
    
    final FichaRepository fichaRepository;

    public FichaService(FichaRepository fichaRepository) {
        this.fichaRepository = fichaRepository;
    }
}
