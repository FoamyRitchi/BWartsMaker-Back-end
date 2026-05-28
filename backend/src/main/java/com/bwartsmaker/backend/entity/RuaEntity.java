package com.bwartsmaker.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data

@Entity

public class RuaEntity {
    @Id
    @GeneratedValue

    @Column(nullable = false)
    private String nome_rua;
}
