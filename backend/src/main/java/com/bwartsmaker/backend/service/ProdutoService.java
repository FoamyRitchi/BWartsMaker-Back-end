package com.bwartsmaker.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwartsmaker.backend.entity.ProdutoEntity;
import com.bwartsmaker.backend.repository.ProdutoRepository;

@Service
public class ProdutoService {


@Autowired
private ProdutoRepository produtoRepository;

public ProdutoEntity criarProduto(
        ProdutoEntity produto) {

    return produtoRepository.save(produto);
}

public List<ProdutoEntity> listarTodosProdutos() {

    return produtoRepository.findAll();
}

public ProdutoEntity buscarPorId(
        Long id) {

    return produtoRepository
            .findById(id)
            .orElseThrow(() ->
                new RuntimeException(
                    "Produto não encontrado com o id: "
                    + id
                )
            );
}

public ProdutoEntity atualizarProduto(
        Long id,
        ProdutoEntity produtoAtualizado) {

    ProdutoEntity produtoExistente =
            buscarPorId(id);

    produtoExistente.setNome_prod(
            produtoAtualizado.getNome_prod()
    );

    produtoExistente.setDesc_prod(
            produtoAtualizado.getDesc_prod()
    );

    produtoExistente.setQntd_prod(
            produtoAtualizado.getQntd_prod()
    );

    produtoExistente.setImg_prod(
            produtoAtualizado.getImg_prod()
    );

    produtoExistente.setFrete_prod(
            produtoAtualizado.getFrete_prod()
    );

    produtoExistente.setValor_prod(
            produtoAtualizado.getValor_prod()
    );

    produtoExistente.setCategoria_prod(
            produtoAtualizado.getCategoria_prod()
    );

    return produtoRepository.save(
            produtoExistente
    );
}

public void deletarProduto(
        Long id) {

    ProdutoEntity produtoExistente =
            buscarPorId(id);

    produtoRepository.delete(
            produtoExistente
    );
}


}
