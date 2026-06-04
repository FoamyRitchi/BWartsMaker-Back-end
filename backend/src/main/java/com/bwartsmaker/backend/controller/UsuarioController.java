package com.bwartsmaker.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bwartsmaker.backend.entity.UsuarioEntity;
import com.bwartsmaker.backend.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioEntity>> getAllUsuarios() {

        return ResponseEntity.ok(
                usuarioService.listarTodosUsuarios()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity> getUsuarioById(
            @PathVariable Long id) {

        UsuarioEntity usuario = usuarioService.buscarPorId(id);

        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<UsuarioEntity> createUsuario(
            @RequestBody UsuarioEntity usuario) {

        UsuarioEntity novoUsuario =
                usuarioService.criarUsuario(usuario);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(novoUsuario);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody Map<String, String> dados) {

        String email = dados.get("email_user");
        String senha = dados.get("senha_user");

        UsuarioEntity usuario =
                usuarioService.autenticar(email, senha);

        if (usuario == null) {

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of(
                            "message",
                            "Email ou senha inválidos."
                    ));
        }

        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioEntity> updateUsuario(
            @PathVariable Long id,
            @RequestBody UsuarioEntity usuario) {

        UsuarioEntity usuarioAtualizado =
                usuarioService.atualizarUsuario(id, usuario);

        return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(
            @PathVariable Long id) {

        usuarioService.deletarUsuario(id);

        return ResponseEntity.noContent().build();
    }
}