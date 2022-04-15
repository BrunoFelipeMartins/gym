package com.academy.gym.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import com.academy.gym.models.AlunoPlano;
import com.academy.gym.repositories.AlunoPlanoRepository;

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
public class AlunoPlanoController {

    @Autowired
    private AlunoPlanoRepository alunoPlanoRepository;
    
    @GetMapping("/alunoPlano")
    public ResponseEntity<List<AlunoPlano>> GetAllPlanos(){
        List<AlunoPlano> alunoPlanoList = alunoPlanoRepository.findAll();
        if (alunoPlanoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<List<AlunoPlano>>(alunoPlanoList, HttpStatus.OK);
        }
    }

    @GetMapping("/alunoPlano/{id}")
    public ResponseEntity<AlunoPlano> getOnePlanos(@PathVariable(value="id") UUID id) {
        Optional<AlunoPlano> alunoPlanoO = alunoPlanoRepository.findById(id);
        if (!alunoPlanoO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<AlunoPlano>(alunoPlanoO.get(), HttpStatus.OK);
        }
    }

    @PostMapping("/alunoPlano")
    public ResponseEntity<AlunoPlano> savePlanos(@RequestBody @Valid AlunoPlano alunoPlano) {
        return new ResponseEntity<AlunoPlano>(alunoPlanoRepository.save(alunoPlano), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/alunoPlano/{id}")
    public ResponseEntity<?> deletePlanos(@PathVariable(value="id") UUID id) {
        Optional<AlunoPlano> alunoPlanoO = alunoPlanoRepository.findById(id);
        if(!alunoPlanoO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            alunoPlanoRepository.delete(alunoPlanoO.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    
    @PutMapping("/alunoPlano/{id}")
    public ResponseEntity<AlunoPlano> update(@PathVariable(value="id")UUID id, @RequestBody @Valid AlunoPlano alunoPlano ) {
        Optional<AlunoPlano> alunoPlanoO = alunoPlanoRepository.findById(id);
        if (!alunoPlanoO.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<AlunoPlano>(alunoPlanoRepository.save(alunoPlano), HttpStatus.OK); 
        }
    }
}
