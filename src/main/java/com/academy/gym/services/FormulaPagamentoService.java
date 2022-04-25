package com.academy.gym.services;

import com.academy.gym.repositories.FormulaPagamentoRepository;

import org.springframework.stereotype.Service;

@Service
public class FormulaPagamentoService {
    
    final FormulaPagamentoRepository formulaPagamentoRepository;

    public FormulaPagamentoService(FormulaPagamentoRepository formulaPagamentoRepository){
        this.formulaPagamentoRepository = formulaPagamentoRepository;
    }
}
