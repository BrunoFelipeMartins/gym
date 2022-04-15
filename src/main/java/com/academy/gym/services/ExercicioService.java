package com.academy.gym.services;

import com.academy.gym.repositories.ExercicioRepository;

import org.springframework.stereotype.Service;

@Service
public class ExercicioService {
    
    final ExercicioRepository exercicioRepository;

    public ExercicioService(ExercicioRepository exercicioRepository){
        this.exercicioRepository = exercicioRepository;
    }


}
