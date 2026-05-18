package com.bwartsmaker.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Data

@Entity

public class EstadoEntity {
    

    @Column(nullable = false)
    private String nome_estado;
}
