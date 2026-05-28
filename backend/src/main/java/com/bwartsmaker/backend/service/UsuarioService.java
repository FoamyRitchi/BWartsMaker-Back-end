package com.bwartsmaker.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwartsmaker.backend.entity.EnderecoEntity;
import com.bwartsmaker.backend.entity.TelefoneEntity;
import com.bwartsmaker.backend.entity.UsuarioEntity;
import com.bwartsmaker.backend.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // =========================
    // CRIAR USUÁRIO
    // =========================
    @Transactional
    public UsuarioEntity criarUsuario(UsuarioEntity usuario) {

        // Garante que endereço e telefone não sejam nulos
        if (usuario.getEndereco() == null) {
            usuario.setEndereco(new EnderecoEntity());
        }

        if (usuario.getTelefone() == null) {
            usuario.setTelefone(new TelefoneEntity());
        }

        return usuarioRepository.save(usuario);
    }

    // =========================
    // LISTAR TODOS
    // =========================
    public List<UsuarioEntity> listarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    // =========================
    // BUSCAR POR ID
    // =========================
    public UsuarioEntity buscarPorId(Long id) {

        return usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Usuário não encontrado com o id: " + id
                        )
                );
    }

    // =========================
    // ATUALIZAR USUÁRIO
    // =========================
    @Transactional
    public UsuarioEntity atualizarUsuario(Long id, UsuarioEntity usuarioAtualizado) {

        UsuarioEntity usuarioExistente = buscarPorId(id);

        // =========================
        // Atualiza dados do usuário
        // =========================
        usuarioExistente.setNome_user(usuarioAtualizado.getNome_user());
        usuarioExistente.setEmail_user(usuarioAtualizado.getEmail_user());
        usuarioExistente.setDataNasc_user(usuarioAtualizado.getDataNasc_user());
        usuarioExistente.setCpf_user(usuarioAtualizado.getCpf_user());
        usuarioExistente.setSenha_user(usuarioAtualizado.getSenha_user());

        // =========================
        // Atualiza endereço
        // =========================
        if (usuarioAtualizado.getEndereco() != null) {

            // Se não existir endereço no banco, cria um novo
            if (usuarioExistente.getEndereco() == null) {
                usuarioExistente.setEndereco(new EnderecoEntity());
            }

            usuarioExistente.getEndereco().setRua(
                    usuarioAtualizado.getEndereco().getRua()
            );

            usuarioExistente.getEndereco().setNumero_endereco (
                    usuarioAtualizado.getEndereco().getNumero_endereco()
            );

            usuarioExistente.getEndereco().setBairro(
                    usuarioAtualizado.getEndereco().getBairro()
            );

            usuarioExistente.getEndereco().setCidade(
                    usuarioAtualizado.getEndereco().getCidade()
            );

            usuarioExistente.getEndereco().setEstado(
                    usuarioAtualizado.getEndereco().getEstado()
            );

            usuarioExistente.getEndereco().setCep_endereco (
                    usuarioAtualizado.getEndereco().getCep_endereco()
            );
        }

        // =========================
        // Atualiza telefone
        // =========================
        if (usuarioAtualizado.getTelefone() != null) {

            // Se não existir telefone no banco, cria um novo
            if (usuarioExistente.getTelefone() == null) {
                usuarioExistente.setTelefone(new TelefoneEntity());
            }

            usuarioExistente.getTelefone().setDdd_telefone(
                    usuarioAtualizado.getTelefone().getDdd_telefone()
            );

            usuarioExistente.getTelefone().setNumero_telefone(
                    usuarioAtualizado.getTelefone().getNumero_telefone()
            );
        }

        return usuarioRepository.save(usuarioExistente);
    }

    // =========================
    // DELETAR USUÁRIO
    // =========================
    @Transactional
    public void deletarUsuario(Long id) {

        UsuarioEntity usuarioExistente = buscarPorId(id);

        usuarioRepository.delete(usuarioExistente);
    }
}