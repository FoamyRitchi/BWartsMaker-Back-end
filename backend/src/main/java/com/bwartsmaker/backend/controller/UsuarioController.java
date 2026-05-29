package com.bwartsmaker.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bwartsmaker.backend.entity.UsuarioEntity;
import com.bwartsmaker.backend.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioEntity> getAllUsuarios() {
        return usuarioService.listarTodosUsuarios();
    }

    @GetMapping("/{id}")
    public UsuarioEntity getUsuarioById(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @PostMapping
    public UsuarioEntity createUsuario(@RequestBody UsuarioEntity usuario) {
        return usuarioService.criarUsuario(usuario);
    }

    @PostMapping("/login")
    public UsuarioEntity login(@RequestBody Map<String, String> dados) {

        return usuarioService.autenticar (
            dados.get("email_user"),
            dados.get("senha_user")
        );
    }

    @PutMapping("/{id}")
    public UsuarioEntity updateUsuario(
            @PathVariable Long id,
            @RequestBody UsuarioEntity usuario) {

        return usuarioService.atualizarUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
    }
}