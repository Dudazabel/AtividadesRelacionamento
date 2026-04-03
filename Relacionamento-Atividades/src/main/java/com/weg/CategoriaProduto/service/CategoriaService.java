package com.weg.CategoriaProduto.service;

import com.weg.CategoriaProduto.dto.categoria.CategoriaRequisicaoDTO;
import com.weg.CategoriaProduto.dto.categoria.CategoriaRespostaDTO;
import com.weg.CategoriaProduto.mapper.CategoriaMapper;
import com.weg.CategoriaProduto.model.Categoria;
import com.weg.CategoriaProduto.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository repository;
    private final CategoriaMapper mapper;

    public CategoriaRespostaDTO cadastrarCategoria(CategoriaRequisicaoDTO categoria){
        Categoria categoriaSalva = mapper.DTOParaEntidade(categoria);
        return mapper.EntidadeParaDTO(repository.save(categoriaSalva));
    }

    public List<CategoriaRespostaDTO> listarCategorias(){
        return mapper.EntidadeParaDTOList(repository.findAll());
    }

    public CategoriaRespostaDTO buscarCategoriaPorID(Long id){
        return mapper.EntidadeParaDTO(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada!")));
    }

    public CategoriaRespostaDTO atualizarCategoria(Long id, CategoriaRequisicaoDTO categoria){
        Categoria categoriaSalva = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));
        categoriaSalva.setNome(categoria.nome());
        categoriaSalva.setDescricao(categoria.descricao());
        return mapper.EntidadeParaDTO(repository.save(categoriaSalva));
    }

    public void deletarCategoria(Long id){
        repository.deleteById(id);
    }
}
