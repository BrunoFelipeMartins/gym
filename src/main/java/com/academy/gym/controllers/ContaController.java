package com.academy.gym.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import com.academy.gym.models.Conta;
import com.academy.gym.repositories.ContaRepository;

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
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;

    @GetMapping("/contas")
    public ResponseEntity<List<Conta>> getAllContas() {
        List<Conta> contaList = contaRepository.findAll();
        if(contaList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
        return new ResponseEntity<List<Conta>>(contaList, HttpStatus.OK);
        }
    }
    
    @GetMapping("/contas/{id}")
    public ResponseEntity<Conta> getOneConta(@PathVariable(value="id") UUID id) {
        Optional<Conta> contaO = contaRepository.findById(id);
        if (!contaO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<Conta>(contaO.get(),HttpStatus.OK);
        }
    }

    @PostMapping("/contas")
    public ResponseEntity<Conta> saveConta(@RequestBody @Valid Conta conta) {
        return new ResponseEntity<Conta>(contaRepository.save(conta), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/contas/{id}")
    public ResponseEntity<?> deleteConta(@PathVariable(value="id") UUID id) {
        Optional<Conta> contaO = contaRepository.findById(id);
        if(!contaO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            contaRepository.delete(contaO.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    

    @PutMapping("/contas/{id}")
    public ResponseEntity<Conta> update(@PathVariable(value="id")UUID id, @RequestBody @Valid Conta conta) {
        Optional<Conta> contaO = contaRepository.findById(id);
        if (!contaO.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Conta>(contaRepository.save(conta), HttpStatus.OK); 
        }
    }

    
}
