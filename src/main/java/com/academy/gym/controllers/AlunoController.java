package com.academy.gym.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import com.academy.gym.models.Aluno;
import com.academy.gym.repositories.AlunoRepository;

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
public class AlunoController {
    
    @Autowired
    private AlunoRepository alunoRepository;
    
    @GetMapping("/alunos")
    public ResponseEntity<List<Aluno>> getAllAlunos() {
        List<Aluno> alunosList = alunoRepository.findAll();
        if(alunosList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
        return new ResponseEntity<List<Aluno>>(alunosList, HttpStatus.OK);
        }
    }
    
    @GetMapping("/alunos/{id}")
    public ResponseEntity<Aluno> getOneAluno(@PathVariable(value="id") UUID id) {
        Optional<Aluno> alunoO = alunoRepository.findById(id);
        if (!alunoO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<Aluno>(alunoO.get(),HttpStatus.OK);
        }
    }
    
    /*@GetMapping("/alunos/{nome}")
    public ResponseEntity<Aluno> getOneAluno(@PathVariable(value="nome") String nome) {
        Optional<Aluno> alunoO = alunoRepository.findByNome(nome);
        if (!alunoO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<Aluno>(alunoO.get(),HttpStatus.OK);
        }
    }*/

    @GetMapping("/alunos/{cpf}")
    public ResponseEntity<Aluno> getOneAluno(@PathVariable(value="cpf") String cpf ) {
        Optional<Aluno> alunoO = alunoRepository.findByCpf(cpf);
        if (!alunoO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<Aluno>(alunoO.get(),HttpStatus.OK);
        }
    }

    @PostMapping("/alunos")
    public ResponseEntity<Aluno> saveAluno(@RequestBody @Valid Aluno aluno) {
        return new ResponseEntity<Aluno>(alunoRepository.save(aluno), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/alunos/{id}")
    public ResponseEntity<?> deleteAluno(@PathVariable(value="id") UUID id) {
        Optional<Aluno> alunoO = alunoRepository.findById(id); //duvida teria como inserir delete para cpf junto.
        if(!alunoO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            alunoRepository.delete(alunoO.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    

    @PutMapping("/alunos/{id}")
    public ResponseEntity<Aluno> update(@PathVariable(value="id")UUID id, @RequestBody @Valid Aluno aluno ) {
        Optional<Aluno> alunoO = alunoRepository.findById(id);
        if (!alunoO.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Aluno>(alunoRepository.save(aluno), HttpStatus.OK); 
        }
    }
}
