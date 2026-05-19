package com.bwartsmaker.backend.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Data

@Entity
@Table(name = "produto")

public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prod;

    @Column(nullable = false)
    private String nome_prod;

    @Column(nullable = false)
    private String desc_prod;

    @Column(nullable = false)
    private int qntd_prod;

    @Column(nullable = false)
    private String img_prod;

    @Column(nullable = false)
    private double frete_prod;

    @Column(nullable = false)
    private double valor_prod;

    private LocalDateTime data_cadastro_prod;

    @PrePersist
    protected void onCreate() {
        this.data_cadastro_prod = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "produto")
    private List<ProdutoCategoriaEntity> produtoCategorias;



}
