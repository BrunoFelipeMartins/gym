/*package com.academy.gym.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import com.academy.gym.models.Aluno;
import com.academy.gym.repositories.AlunoRepository;

import org.springframework.stereotype.Service;


@Service
public class AlunoService {

    final AlunoRepository AlunoRepository; 

    public AlunoService(AlunoRepository alunoRepository){
        this.AlunoRepository = alunoRepository;
    }

    @Transactional
    public Aluno save(Aluno aluno){
       return this.AlunoRepository.save(aluno);
    }
    public List<Aluno>getAll(){
        return this.AlunoRepository.findAll();
    }
    public Aluno getById(Aluno aluno){
       return this.AlunoRepository.getById(aluno.getId());
    }
    public Optional<Aluno> findById(UUID id) {
        return this.AlunoRepository.findById(id);
    }
    public void update(UUID id){
        Optional<Aluno> aluno = this.AlunoRepository.findById(id);
        this.AlunoRepository.save(aluno);
    }
    public void delete(UUID id){
        Optional<Aluno> aluno = this.AlunoRepository.findById(id);
        this.AlunoRepository.delete(aluno);
    }
    
}*/
