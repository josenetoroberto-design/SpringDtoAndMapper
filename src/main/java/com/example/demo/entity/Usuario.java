package com.example.demo.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table (name= "usuario")
@Entity
@EqualsAndHashCode (of= "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name= "nome")
    private String nome;

    @Column(name= "email")
    private String email;

    @Column(name= "senha")
    private String senha;

    @Column(name= "data_criado")
    private Instant dataCriado;

}
