package com.academy.gym.services;

import com.academy.gym.repositories.PlanoRepository;

import org.springframework.stereotype.Service;

@Service
public class PlanoService {

    final PlanoRepository planoRepository;
    
    public PlanoService(PlanoRepository planoRepository){
        this.planoRepository = planoRepository;
    }

}
