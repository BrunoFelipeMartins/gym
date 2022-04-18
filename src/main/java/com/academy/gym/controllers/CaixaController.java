package com.academy.gym.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import com.academy.gym.models.Caixa;
import com.academy.gym.repositories.CaixaRepository;

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
public class CaixaController {
    
    @Autowired
    private CaixaRepository caixaRepository;

    @GetMapping("/caixa")
    public ResponseEntity<List<Caixa>> getAllCaixa() {
    List<Caixa> caixaList = caixaRepository.findAll();
    if(caixaList.isEmpty()){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }else {
        return new ResponseEntity<List<Caixa>>(caixaList, HttpStatus.OK);
    }
    }

    @GetMapping("/caixa/{id}")
    public ResponseEntity<Caixa> getOneCaixa(@PathVariable(value="id") UUID id) {
        Optional<Caixa> caixaO = caixaRepository.findById(id);
        if(!caixaO.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<Caixa>(caixaO.get(), HttpStatus.OK);
    }
    }

    @PostMapping("/caixa")
    public ResponseEntity<Caixa> saveCaixa(@RequestBody @Valid Caixa caixa) {
        return new ResponseEntity<Caixa>(caixaRepository.save(caixa), HttpStatus.CREATED);
    }

    @DeleteMapping("/caixa/{id}")
    public ResponseEntity<?> deleteCaixa(@PathVariable(value="id") UUID id) {
        Optional<Caixa> caixa0 = caixaRepository.findById(id);
        if(!caixa0.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            caixaRepository.delete(caixa0.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping(value="/caixa/{id}")
    public ResponseEntity<Caixa> updateCaixa(@PathVariable(value="id") UUID id, @RequestBody @Valid Caixa caixa) {
        Optional<Caixa> caixa0 = caixaRepository.findById(id);
        if(!caixa0.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            caixa.setId(caixa0.get().getId());
            return new ResponseEntity<Caixa>(caixaRepository.save(caixa), HttpStatus.OK);
        }
    }
}

