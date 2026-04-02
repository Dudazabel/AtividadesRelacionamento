package com.weg.CategoriaProduto.service;

import com.weg.CategoriaProduto.dto.produto.ProdutoRequisicaoDTO;
import com.weg.CategoriaProduto.dto.produto.ProdutoRespostaDTO;
import com.weg.CategoriaProduto.mapper.ProdutoMapper;
import com.weg.CategoriaProduto.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper mapper;

    public ProdutoRespostaDTO cadastrarProduto(ProdutoRequisicaoDTO produto){

    }
}
