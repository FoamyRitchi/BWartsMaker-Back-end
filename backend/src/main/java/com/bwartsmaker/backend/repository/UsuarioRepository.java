package com.bwartsmaker.backend.repository;

import com.bwartsmaker.backend.entity.UsuarioEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository <UsuarioEntity, Long> {
     @Query("""
        SELECT u
        FROM UsuarioEntity u
        WHERE u.email_user = :email
        AND u.senha_user = :senha
    """)
    
    Optional<UsuarioEntity> autenticar(
        @Param("email") String email,
        @Param("senha") String senha
    );
}
