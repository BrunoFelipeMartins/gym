package com.academy.gym.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "PLANO")
public class Plano implements Serializable {
    private static final long serialVersionUID = 1l;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "plano")
    private AlunoPlano alunoPlano;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 50)
    private String descricao;
    @Column(nullable = false, length = 15)
    private String valor;
    @Column(nullable = false, length = 8)
    private int diasVencer;

    
}
