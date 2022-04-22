package com.academy.gym.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ALUNO_PLANO")
public class AlunoPlano implements Serializable{
    private static final long serialVersionUID = 1l;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alunoId")
    private List<Aluno> aluno;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planoId")
    private List<Plano> plano;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formulaPagamentoId")
    private FormulaPagamento formulaPagamento;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "alunoplano")
    private Conta conta;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 8)
    private Date dataInicio;
    @Column(nullable = false, length = 8)
    private Date dataFim;
    

    
}