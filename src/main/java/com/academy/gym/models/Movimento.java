package com.academy.gym.models;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "MOVIMENTO")
public class Movimento implements Serializable {
    public static final long serialVersionUID = 1l;

    @OneToOne
    private Movimento movimento;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 30)
    private String sangria;
    @Column(nullable = false, length = 30)
    private String sumplimento;
    @Column(nullable = false, length = 30)
    private String descricao;
    @Column(nullable = false, length = 30)
    private Date data;
    @Column(nullable = false, length = 30)
    private String valor;
    @Column(nullable = false, length = 30)
    private String status;

}
