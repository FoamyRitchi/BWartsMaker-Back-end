package com.bwartsmaker.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

@Table(name = "telefone")
public class TelefoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_telefone;

    @Column(nullable = false)
    private String ddd_telefone;
    
    @Column(nullable = false)
    private String numero_telefone;

    
}