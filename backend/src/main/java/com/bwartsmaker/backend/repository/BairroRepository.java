package com.bwartsmaker.backend.repository;

import com.bwartsmaker.backend.entity.BairroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BairroRepository extends JpaRepository<BairroEntity, Long> {
    
}
