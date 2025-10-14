package com.example.jpa_h2_demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer idade;
    private String email;

    @OneToMany(mappedBy = "cliente")
    private List<Telefone> telefones;

    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos;
}
