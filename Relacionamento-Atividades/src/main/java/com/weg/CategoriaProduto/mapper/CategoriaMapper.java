package com.weg.CategoriaProduto.mapper;

import com.weg.CategoriaProduto.dto.categoria.CategoriaRequisicaoDTO;
import com.weg.CategoriaProduto.dto.categoria.CategoriaRespostaDTO;
import com.weg.CategoriaProduto.model.Categoria;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaMapper {

    public Categoria DTOParaEntidade(CategoriaRequisicaoDTO categoria){
        return new Categoria(
                categoria.nome(),
                categoria.descricao());
    }

    public CategoriaRespostaDTO EntidadeParaDTO(Categoria categoria){
        return new CategoriaRespostaDTO(
                categoria.getId(),
                categoria.getNome(),
                categoria.getDescricao());
    }

    public List<CategoriaRespostaDTO> EntidadeParaDTOList(List<Categoria> categorias){
        return categorias
                .stream()
                .map(this::EntidadeParaDTO)
                .toList();
    }
}
