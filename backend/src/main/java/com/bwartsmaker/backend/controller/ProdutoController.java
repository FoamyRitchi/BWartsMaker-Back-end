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

    @GetMapping
    public List<ProdutoEntity> getAllProdutos() {
        return produtoService.listarTodosProdutos();
    }

    @GetMapping("/{id}")
    public ProdutoEntity getProdutoById(
            @PathVariable Long id) {

        return produtoService.buscarPorId(id);
    }

    @PostMapping
    public ProdutoEntity createProduto(
            @RequestBody ProdutoEntity produto) {

        return produtoService.criarProduto(produto);
    }

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

            @RequestParam(value = "imagem", required = false)
            MultipartFile imagem) {

        try {

            System.out.println("========== NOVO PRODUTO ==========");

            System.out.println("Nome: " + nome);
            System.out.println("Descrição: " + descricao);
            System.out.println("Quantidade: " + quantidade);
            System.out.println("Valor: " + valor);
            System.out.println("Frete: " + frete);

            if (imagem == null) {

                System.out.println("Imagem recebida: NULL");

            } else {

                System.out.println("Imagem recebida: "
                        + imagem.getOriginalFilename());

                System.out.println("Tamanho arquivo: "
                        + imagem.getSize());

                System.out.println("Está vazia? "
                        + imagem.isEmpty());
            }

            String caminhoImagem = "";

            if (imagem != null && !imagem.isEmpty()) {

                String pastaUpload = "uploads";

                Files.createDirectories(
                        Paths.get(pastaUpload));

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

                System.out.println(
                        "Imagem salva em: "
                        + caminhoImagem
                );
            }

            ProdutoEntity produto =
                    new ProdutoEntity();

            produto.setNome_prod(nome);
            produto.setDesc_prod(descricao);
            produto.setQntd_prod(quantidade);
            produto.setValor_prod(valor);
            produto.setFrete_prod(frete);
            produto.setImg_prod(caminhoImagem);

            ProdutoEntity produtoSalvo =
                    produtoService.criarProduto(produto);

            System.out.println(
                    "Produto salvo com ID: "
                    + produtoSalvo.getId_prod()
            );

            System.out.println(
                    "Campo img_prod salvo: "
                    + produtoSalvo.getImg_prod()
            );

            System.out.println(
                    "=================================="
            );

            return produtoSalvo;

        } catch (IOException e) {

            e.printStackTrace();

            throw new RuntimeException(
                    "Erro ao salvar imagem.",
                    e
            );
        }
    }

    @PutMapping("/{id}")
    public ProdutoEntity updateProduto(
            @PathVariable Long id,
            @RequestBody ProdutoEntity produto) {

        return produtoService.atualizarProduto(
                id,
                produto
        );
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(
            @PathVariable Long id) {

        produtoService.deletarProduto(id);
    }
}