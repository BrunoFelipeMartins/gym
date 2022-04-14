/*package com.academy.gym.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import com.academy.gym.models.Aluno;
import com.academy.gym.services.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@EnableJpaRepositories
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/aluno")
public class AlunoController {
    
    @Autowired
    final AlunoService alunoService;
    
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/aluno")
    public List<Aluno> getAluno(){
        return alunoService.getAll();
    }

    @GetMapping("/{id}")
    public Aluno listaAlunounico(@PathVariable(value="id")UUID id) {
        Aluno aluno = new Aluno();
        aluno.setId(id);
        return alunoService.getById(aluno);
    }
    //@GetMapping CPF

  /*@PostMapping()
    public Aluno save(@RequestBody Aluno aluno) {
       return alunoService.save(aluno);
    }
    
    @PostMapping()  
    private Aluno saveAluno(@PathVariable(value="id")UUID id,@RequestBody @Valid Aluno aluno) {
        Optional<Aluno> alunoOptional = alunoService.findById(id);
        return alunoService.save(aluno);  
    }*/  
    /*@PostMapping("/aluno")
    public ResponseEntity<Object> salvar(@RequestBody @Valid Aluno aluno){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.save(aluno));
    }

    @DeleteMapping("/{id}")
    public void deleteAluno(@RequestBody UUID id) {
        alunoService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value="id")UUID id, @RequestBody @Valid Aluno aluno ){
        Optional<Aluno> alunoOptional = alunoService.findById(id);
        if (!alunoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno not found.");
        }
       return ResponseEntity.status(HttpStatus.OK).body(alunoService.save(aluno));
        
    }
}
*/