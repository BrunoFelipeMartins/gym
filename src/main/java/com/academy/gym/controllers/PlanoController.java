package com.academy.gym.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import com.academy.gym.models.Plano;
import com.academy.gym.repositories.PlanoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlanoController {
    
    @Autowired
    private PlanoRepository planoRepository;

    @GetMapping("/planos")
    public ResponseEntity<List<Plano>> getAllPlanos() {
        List<Plano> planoList = planoRepository.findAll();
        if(planoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
        return new ResponseEntity<List<Plano>>(planoList, HttpStatus.OK);
        }
    }
    
    @GetMapping("/planos/{id}")
    public ResponseEntity<Plano> getOnePlano(@PathVariable(value="id") UUID id) {
        Optional<Plano> planoO = planoRepository.findById(id);
        if (!planoO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<Plano>(planoO.get(),HttpStatus.OK);
        }
    }

    @PostMapping("/planos")
    public ResponseEntity<Plano> savePlano(@RequestBody @Valid Plano plano) {
        return new ResponseEntity<Plano>(planoRepository.save(plano), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/planos/{id}")
    public ResponseEntity<?> deletePlano(@PathVariable(value="id") UUID id) {
        Optional<Plano> planoO = planoRepository.findById(id);
        if(!planoO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            planoRepository.delete(planoO.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    

    @PutMapping("/planos/{id}")
    public ResponseEntity<Plano> update(@PathVariable(value="id")UUID id, @RequestBody @Valid Plano plano) {
        Optional<Plano> planoO = planoRepository.findById(id);
        if (!planoO.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Plano>(planoRepository.save(plano), HttpStatus.OK); 
        }
    }
}
