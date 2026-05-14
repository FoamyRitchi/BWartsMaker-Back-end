package com.bwartsmaker.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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

    @OneToMany
    @JoinColumn(name = "id_rua", referencedColumnName = "id_rua")
    private RuaEntity rua;

    @OneToMany
    @JoinColumn(name = "id_bairro", referencedColumnName = "id_bairro")
    private BairroEntity bairro;

    @OneToMany
    @JoinColumn(name = "id_cidade", referencedColumnName = "id_cidade")
    private CidadeEntity cidade;

    @OneToMany
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    private EstadoEntity estado;


}
