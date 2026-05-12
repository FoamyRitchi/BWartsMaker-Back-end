package com.bwartsmaker.backend.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data

@Entity

@Table(name="usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(nullable = false)
    private String nome_user;

    @Column(nullable = false)
    private String email_user;

    @Column(nullable = false)
    private int idade_user;

    @Column(nullable = false)
    private Long cpf;
}
