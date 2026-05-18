package com.bwartsmaker.backend.repository;

import com.bwartsmaker.backend.entity.RuaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RuaRepository extends JpaRepository<RuaEntity, Long> {
    
}
