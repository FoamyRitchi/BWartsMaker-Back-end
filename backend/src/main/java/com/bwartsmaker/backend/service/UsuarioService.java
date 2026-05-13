package com.bwartsmaker.backend.service;

// Importa as classes "UsuarioEntity" e "UsuarioRepository" para serem usadas no serviço de usuário
import com.bwartsmaker.backend.entity.UsuarioEntity;
import com.bwartsmaker.backend.repository.UsuarioRepository;

// Importa as dependências necessárias para o serviço de usuário
import org.springframework.beans.factory.annotation.Autowired;

// Importa a anotação @Service para marcar esta classe como um serviço do Spring
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UsuarioService {
    // Injeta a dependência do repositório de usuário para que o serviço possa acessar os dados dos usuários
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioEntity criarUsuario(UsuarioEntity usuario) {
        // Salva o usuário no repositório e retorna o usuário criado
        return usuarioRepository.save(usuario);
    }

    public List<UsuarioEntity> listarTodosUsuarios() {
        // Retorna uma lista de todos os usuários encontrados no repositório
        return usuarioRepository.findAll();
    }

    public UsuarioEntity buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado com o id: " + id));
    }
    
}
