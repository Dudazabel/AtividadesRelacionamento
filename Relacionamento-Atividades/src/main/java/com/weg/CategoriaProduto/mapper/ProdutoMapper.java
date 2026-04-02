package com.weg.CategoriaProduto.mapper;

import com.weg.CategoriaProduto.dto.produto.ProdutoRequisicaoDTO;
import com.weg.CategoriaProduto.dto.produto.ProdutoRespostaDTO;
import com.weg.CategoriaProduto.model.Produto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoMapper {

    public Produto DTOParaEntidade(ProdutoRequisicaoDTO produto){
        return new Produto(produto.nome());
    }

    public ProdutoRespostaDTO EntidadeParaDTO(Produto produto){
        return new ProdutoRespostaDTO(produto.getId(), produto.getNome(), produto.getCategoria().getId());
    }

    public List<ProdutoRespostaDTO> EntidadeParaDTOList(List<Produto> produtos){
        return produtos
                .stream()
                .map(this::EntidadeParaDTO)
                .toList();
    }
}
