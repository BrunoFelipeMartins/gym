package com.academy.gym.models;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "ALUNO")
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 50)
    private String nome;
    @Column(nullable = false, length = 10)
    private String genero;
    @Column(nullable = false, length = 13)
    private String telefone;
    @Column(nullable = false, length = 12)
    private Date dataNascimento;
    @Column(nullable = false, length = 11)
    private String cpf;
    @Column(nullable = false, length = 70)
    private String email;
    @Column(nullable = false, length = 10)
    private String cep;
    @Column(nullable = false, length = 40)
    private String rua;
    @Column(nullable = false, length = 10)
    private String numero;
    @Column(nullable = false, length = 20)
    private String cidade;
    @Column(nullable = false, length = 20)
    private String estado;
    
    

}
