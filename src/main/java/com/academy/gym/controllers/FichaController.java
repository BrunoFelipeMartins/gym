package com.academy.gym.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import com.academy.gym.models.Ficha;
import com.academy.gym.repositories.FichaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class FichaController {

    @Autowired
    private FichaRepository fichaRepository;
    
    @GetMapping("/fichas")
    public ResponseEntity<List<Ficha>> getAllFichas() {
        List<Ficha> fichasList = fichaRepository.findAll();
        if(fichasList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<List<Ficha>>(fichasList, HttpStatus.OK);
        }
    }
    
    @GetMapping("/fichas/{id}")
    public ResponseEntity<Ficha> getOneFicha(@PathVariable(value="id") UUID id) {
        Optional<Ficha> ficha0 = fichaRepository.findById(id);
        if (!ficha0.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<Ficha>(ficha0.get(), HttpStatus.OK);
        }
    }

    @PostMapping("/fichas")
    public ResponseEntity<Ficha> saveFicha(@RequestBody @Valid Ficha ficha) {
        return new ResponseEntity<Ficha>(fichaRepository.save(ficha), HttpStatus.CREATED);
    }

    @DeleteMapping("/fichas/{id}")
    public ResponseEntity<?> deleteFicha(@PathVariable(value="id") UUID id) {
        Optional<Ficha> ficha0 = fichaRepository.findById(id);
        if(!ficha0.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            fichaRepository.delete(ficha0.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping(value="/fichas/{id}")
    public ResponseEntity<Ficha> updateFicha(@PathVariable(value="id") UUID id, @RequestBody @Valid Ficha ficha) {
        Optional<Ficha> ficha0 = fichaRepository.findById(id);
        if(!ficha0.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            ficha.setId(ficha0.get().getId());
            return new ResponseEntity<Ficha>(fichaRepository.save(ficha), HttpStatus.OK);
        }
    }
    }
    

