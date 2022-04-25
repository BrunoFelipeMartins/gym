package com.academy.gym.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import com.academy.gym.models.FormulaPagamento;
import com.academy.gym.repositories.FormulaPagamentoRepository;

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
public class FormulaPagamentoController {
    
    @Autowired
    private FormulaPagamentoRepository formulaPagamentoRepository;

    @GetMapping("/formulaPagamento")
    public ResponseEntity<List<FormulaPagamento>> getAllFormulaPagamento() {
        List<FormulaPagamento> formulaPagamentoList = formulaPagamentoRepository.findAll();
        if(formulaPagamentoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<List<FormulaPagamento>>(formulaPagamentoList, HttpStatus.OK);
        }
    }

    @GetMapping("/formulaPagamento/{id}")
    public ResponseEntity<FormulaPagamento> getOneFormulaPagamento(@PathVariable(value="id") UUID id) {
        Optional<FormulaPagamento> formulaPagamentoO = formulaPagamentoRepository.findById(id);
        if(!formulaPagamentoO.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<FormulaPagamento>(formulaPagamentoO.get(), HttpStatus.OK);
        }
    }

    @PostMapping("/formulaPagamento")
    public ResponseEntity<FormulaPagamento> saveMovimento(@RequestBody @Valid FormulaPagamento formulaPagamento) {
        return new ResponseEntity<FormulaPagamento>(formulaPagamentoRepository.save(formulaPagamento), HttpStatus.CREATED);
    }

    @DeleteMapping("/formulaPagamento/{id}")
    public ResponseEntity<?> deleteMovimento(@PathVariable(value="id") UUID id) {
        Optional<FormulaPagamento> formulaPagamento0 = formulaPagamentoRepository.findById(id);
        if(!formulaPagamento0.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            formulaPagamentoRepository.delete(formulaPagamento0.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping(value="/formulaPagamento/{id}")
    public ResponseEntity<FormulaPagamento> updateMovimento(@PathVariable(value="id") UUID id, @RequestBody @Valid FormulaPagamento formulaPagamento) {
        Optional<FormulaPagamento> formulaPagamento0 = formulaPagamentoRepository.findById(id);
        if(!formulaPagamento0.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            formulaPagamento.setId(formulaPagamento0.get().getId());
            return new ResponseEntity<FormulaPagamento>(formulaPagamentoRepository.save(formulaPagamento), HttpStatus.OK);
        }
    }

}
