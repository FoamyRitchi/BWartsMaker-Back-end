package com.bwartsmaker.backend.repository;

import com.bwartsmaker.backend.entity.UsuarioEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository <UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByEmailUserAndSenhaUser(
            String email_user,
            String senha_user);
}
