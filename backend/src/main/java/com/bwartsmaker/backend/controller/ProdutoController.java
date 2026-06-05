package com.bwartsmaker.backend.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.bwartsmaker.backend.entity.ProdutoEntity;
import com.bwartsmaker.backend.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // =========================
    // LISTAR TODOS
    // =========================
    @GetMapping
    public List<ProdutoEntity> getAllProdutos() {
        return produtoService.listarTodosProdutos();
    }

    // =========================
    // BUSCAR POR ID
    // =========================
    @GetMapping("/{id}")
    public ProdutoEntity getProdutoById(
            @PathVariable Long id) {

        return produtoService.buscarPorId(id);
    }

    // =========================
    // CADASTRAR SEM IMAGEM
    // =========================
    @PostMapping
    public ProdutoEntity createProduto(
            @RequestBody ProdutoEntity produto) {

        return produtoService.criarProduto(produto);
    }

    // =========================
    // CADASTRAR COM IMAGEM
    // =========================
    @PostMapping(
        value = "/com-imagem",
        consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ProdutoEntity cadastrarProdutoComImagem(

            @RequestParam("nome_prod") String nome,

            @RequestParam("desc_prod") String descricao,

            @RequestParam("qntd_prod") Integer quantidade,

            @RequestParam("valor_prod") Double valor,

            @RequestParam("frete_prod") Double frete,

            @RequestParam("imagem") MultipartFile imagem) {

        try {

            String caminhoImagem = "";

            if (imagem != null && !imagem.isEmpty()) {

                String pastaUpload = "uploads/";

                Files.createDirectories(
                    Paths.get(pastaUpload)
                );

                String nomeArquivo =
                    System.currentTimeMillis()
                    + "_"
                    + imagem.getOriginalFilename();

                Path caminhoArquivo =
                    Paths.get(
                        pastaUpload,
                        nomeArquivo
                    );

                Files.write(
                    caminhoArquivo,
                    imagem.getBytes()
                );

                caminhoImagem =
                    "/uploads/" + nomeArquivo;
            }

            ProdutoEntity produto =
                new ProdutoEntity();

            produto.setNome_prod(nome);
            produto.setDesc_prod(descricao);
            produto.setQntd_prod(quantidade);
            produto.setValor_prod(valor);
            produto.setFrete_prod(frete);
            produto.setImg_prod(caminhoImagem);

            return produtoService
                    .criarProduto(produto);

        } catch (IOException e) {

            throw new RuntimeException(
                "Erro ao salvar imagem.",
                e
            );
        }
    }

    // =========================
    // ATUALIZAR
    // =========================
    @PutMapping("/{id}")
    public ProdutoEntity updateProduto(
            @PathVariable Long id,
            @RequestBody ProdutoEntity produto) {

        return produtoService
                .atualizarProduto(id, produto);
    }

    // =========================
    // DELETAR
    // =========================
    @DeleteMapping("/{id}")
    public void deleteProduto(
            @PathVariable Long id) {

        produtoService.deletarProduto(id);
    }
}