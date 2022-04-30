package com.academy.gym.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "FICHA")
public class Ficha implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @ManyToMany
    @JoinTable(
        name = "FichaExercicios", 
        joinColumns = @JoinColumn(name = "fichaId", referencedColumnName = "id", nullable = true),
        inverseJoinColumns = @JoinColumn(name = "ExercicioId", referencedColumnName = "id", nullable = true))
    private Set<Exercicio> exercicios;

    @ManyToOne
    @JoinColumn(name = "alunoId")
    private Aluno aluno;
    
    /*@ManyToOne
    @JoinColumn(name = "alunoId")
    private Aluno aluno;*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 10)
    private int serie;
    @Column(nullable = false, length = 10)
    private int repeticao;
    @Column(nullable = false, length = 10)    
    private int carga;
    @Column(nullable = false, length = 10)
    private Date dataInicio;
    @Column(nullable = false, length = 10)
    private Date dia;
    
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public int getSerie() {
        return serie;
    }
    public void setSerie(int serie) {
        this.serie = serie;
    }
    public int getRepeticao() {
        return repeticao;
    }
    public void setRepeticao(int repeticao) {
        this.repeticao = repeticao;
    }
    public int getCarga() {
        return carga;
    }
    public void setCarga(int carga) {
        this.carga = carga;
    }
    public Date getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    public Date getDia() {
        return dia;
    }
    public void setDia(Date dia) {
        this.dia = dia;
    }
    
    
}
