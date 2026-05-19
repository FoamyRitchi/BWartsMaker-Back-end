package com.bwartsmaker.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bwartsmaker.backend.entity.ProdutoEntity;
import com.bwartsmaker.backend.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoEntity> getAllProdutos() {
        return produtoService.listarTodosProdutos();
    }

    @GetMapping("/{id}")
    public ProdutoEntity getProdutoById(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }

    @PostMapping
    public ProdutoEntity createProduto(@RequestBody ProdutoEntity produto) {
        return produtoService.criarProduto(produto);
    }

    @PutMapping("/{id}")
    public ProdutoEntity updateProduto(@PathVariable Long id, @RequestBody ProdutoEntity produto) {
        return produtoService.atualizarProduto(id, produto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }
}
