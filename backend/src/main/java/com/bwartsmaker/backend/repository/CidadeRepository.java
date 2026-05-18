package com.bwartsmaker.backend.repository;

import com.bwartsmaker.backend.entity.CidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CidadeRepository extends JpaRepository<CidadeEntity, Long> {
    
}
