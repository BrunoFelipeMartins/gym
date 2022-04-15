package com.academy.gym.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import com.academy.gym.models.Exercicio;
import com.academy.gym.repositories.ExercicioRepository;

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
public class ExercicioController {
    
    @Autowired
    private ExercicioRepository exercicioRepository;

    @GetMapping("/exercicios")
    public ResponseEntity<List<Exercicio>> GetAllExercicios(){
        List<Exercicio> exerciciosList = exercicioRepository.findAll();
        if (exerciciosList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<List<Exercicio>>(exerciciosList, HttpStatus.OK);
        }
    }

    @GetMapping("/exercicios/{id}")
    public ResponseEntity<Exercicio> getOneExercicio(@PathVariable(value="id") UUID id) {
        Optional<Exercicio> exercicioO = exercicioRepository.findById(id);
        if (!exercicioO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Exercicio>(exercicioO.get(), HttpStatus.OK);
        }
    }

    @PostMapping("/exercicios")
    public ResponseEntity<Exercicio> saveAluno(@RequestBody @Valid Exercicio exercicio) {
        return new ResponseEntity<Exercicio>(exercicioRepository.save(exercicio), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/exercicios/{id}")
    public ResponseEntity<?> deleteExercicio(@PathVariable(value="id") UUID id) {
        Optional<Exercicio> exercicioO = exercicioRepository.findById(id);
        if(!exercicioO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            exercicioRepository.delete(exercicioO.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    
    @PutMapping("/exercicios/{id}")
    public ResponseEntity<Exercicio> update(@PathVariable(value="id")UUID id, @RequestBody @Valid Exercicio exercicio ) {
        Optional<Exercicio> exercicioO = exercicioRepository.findById(id);
        if (!exercicioO.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Exercicio>(exercicioRepository.save(exercicio), HttpStatus.OK); 
        }
    }

}
