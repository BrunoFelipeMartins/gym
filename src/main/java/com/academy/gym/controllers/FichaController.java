package com.academy.gym.controllers;

import java.util.List;

import com.academy.gym.models.Ficha;
import com.academy.gym.repositories.FichaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ficha")
public class FichaController {

    @Autowired
    private FichaRepository fichaRepository;
    
    @GetMapping("/")
    public List<Ficha> findAll() {
        return fichaRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Ficha findById(@PathVariable long id) {
        return fichaRepository.findById(id);
            
    }
}
