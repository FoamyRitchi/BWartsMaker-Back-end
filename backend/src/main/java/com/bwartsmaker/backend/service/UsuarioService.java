package com.bwartsmaker.backend.service;

// Importa as classes "UsuarioEntity" e "UsuarioRepository" para serem usadas no serviço de usuário
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwartsmaker.backend.entity.UsuarioEntity;
import com.bwartsmaker.backend.repository.UsuarioRepository;

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

    public UsuarioEntity atualizarUsuario(Long id, UsuarioEntity usuarioAtualizado) {
        UsuarioEntity usuarioExistente = buscarPorId(id);

        usuarioExistente.setNome_user(usuarioAtualizado.getNome_user());
        usuarioExistente.setEmail_user(usuarioAtualizado.getEmail_user());
        usuarioExistente.setDataNasc_user(usuarioAtualizado.getDataNasc_user());
        usuarioExistente.setCpf_user(usuarioAtualizado.getCpf_user());

        return usuarioRepository.save(usuarioExistente);
    }

    public void deletarUsuario(Long id) {
        UsuarioEntity usuarioExistente = buscarPorId(id);
        usuarioRepository.delete(usuarioExistente);
    }
    
}
