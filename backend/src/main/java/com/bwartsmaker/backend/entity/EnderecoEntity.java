package com.bwartsmaker.backend.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data

@Entity

@Table(name = "endereco")
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_endereco;

    @Column(nullable = false)
    private int numero_endereco;

    @Column(nullable = false)
    private Long cep_endereco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_rua")
    private RuaEntity rua;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_bairro")
    private BairroEntity bairro;

    @ManyToOne(cascade = CascadeType.ALL)   
    @JoinColumn(name = "id_cidade")
    private CidadeEntity cidade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_estado")
    private EstadoEntity estado;


}
