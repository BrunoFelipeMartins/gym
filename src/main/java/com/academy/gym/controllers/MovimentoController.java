package com.academy.gym.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import com.academy.gym.models.Movimento;
import com.academy.gym.repositories.MovimentoRepository;

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
public class MovimentoController {
    
    @Autowired
    private MovimentoRepository movimentoRepository;

    @GetMapping("/movimento")
    public ResponseEntity<List<Movimento>> getAllMovimento() {
        List<Movimento> movimentoList = movimentoRepository.findAll();
        if(movimentoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<List<Movimento>>(movimentoList, HttpStatus.OK);
        }
    }

    @GetMapping("/movimento/{id}")
    public ResponseEntity<Movimento> getOneMovimento(@PathVariable(value="id") UUID id) {
        Optional<Movimento> movimentoO = movimentoRepository.findById(id);
        if(!movimentoO.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Movimento>(movimentoO.get(), HttpStatus.OK);
        }
    }

    @PostMapping("/movimento")
    public ResponseEntity<Movimento> saveMovimento(@RequestBody @Valid Movimento movimento) {
        return new ResponseEntity<Movimento>(movimentoRepository.save(movimento), HttpStatus.CREATED);
    }

    @DeleteMapping("/movimento/{id}")
    public ResponseEntity<?> deleteMovimento(@PathVariable(value="id") UUID id) {
        Optional<Movimento> movimento0 = movimentoRepository.findById(id);
        if(!movimento0.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            movimentoRepository.delete(movimento0.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping(value="/movimento/{id}")
    public ResponseEntity<Movimento> updateMovimento(@PathVariable(value="id") UUID id, @RequestBody @Valid Movimento movimento) {
        Optional<Movimento> movimento0 = movimentoRepository.findById(id);
        if(!movimento0.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            movimento.setId(movimento0.get().getId());
            return new ResponseEntity<Movimento>(movimentoRepository.save(movimento), HttpStatus.OK);
        }
    }
}
