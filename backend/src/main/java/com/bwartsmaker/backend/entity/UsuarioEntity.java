package com.bwartsmaker.backend.entity;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.CascadeType;


@Data

@Entity

@Table(name="usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    @Column(nullable = false)
    private String nome_user;

    @Column(nullable = false)
    private String email_user;

    @Column(nullable = false)
    private Date dataNasc_user;

    @Column(nullable = false)
    private String cpf_user;

    @Column(nullable = false)
    private String senha_user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco")
    private EnderecoEntity endereco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_telefone", referencedColumnName = "id_telefone")
    private TelefoneEntity telefone;
}
