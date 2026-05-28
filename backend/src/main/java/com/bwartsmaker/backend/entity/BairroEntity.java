package com.bwartsmaker.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data

@Entity

public class BairroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_bairro;

    @Column(nullable = false)
    private String nome_bairro;
    
}
