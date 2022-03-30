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
@Table(name = "FICHA")
public class Ficha implements Serializable {
    private static final long serialVersionUID = 1L;
    
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
    private Date data_inicio;
    @Column(nullable = false, length = 10)
    private Date dia;
}
