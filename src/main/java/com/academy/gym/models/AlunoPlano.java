package com.academy.gym.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "ALUNO_PLANO")
public class AlunoPlano implements Serializable{
    private static final long serialVersionUID = 1l;

    @ManyToOne
    private List<Aluno> aluno;
    @OneToOne
    private Plano plano;
    private Conta conta;//preciso colocar @OneToOne denovo

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 8)
    private Date dataInicio;
    @Column(nullable = false, length = 8)
    private Date dataFim;
    

    
}