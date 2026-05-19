package com.bwartsmaker.backend.entity;


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

@Table(name="produto_categoria")

public class ProdutoCategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_produto_categoria;

    @ManyToOne
    @JoinColumn(name = "id_prod", referencedColumnName = "id_prod")
    private ProdutoEntity produto;

    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    private CategoriaEntity categoria;
    
}
