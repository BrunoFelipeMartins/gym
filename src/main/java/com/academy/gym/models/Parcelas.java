package com.academy.gym.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "PARCELAS")
public class Parcelas implements Serializable {
    public static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private UUID id;
    @Column(nullable = false, length = 20)
    private int numeroParcelas;
    @Column(nullable = false, length = 20)
    private int dias;
    @Column(nullable = false, length = 20)
    private int qtdParcelas;
    @Column(nullable = false, length = 20)
    private String juros;
    

}
