package com.academy.gym.models;

import java.io.Serializable;
import java.util.UUID;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "EXERCICIOS")
public class Exercicio implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToMany
    private Ficha ficha;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 10)
    private String nome;
    @Column(nullable = false, length = 10)
    private String grupoMuscular;
}

