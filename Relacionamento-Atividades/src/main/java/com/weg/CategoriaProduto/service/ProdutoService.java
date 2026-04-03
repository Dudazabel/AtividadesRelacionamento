package com.weg.CategoriaProduto.service;

import com.weg.CategoriaProduto.dto.produto.ProdutoRequisicaoDTO;
import com.weg.CategoriaProduto.dto.produto.ProdutoRespostaDTO;
import com.weg.CategoriaProduto.mapper.ProdutoMapper;
import com.weg.CategoriaProduto.model.Produto;
import com.weg.CategoriaProduto.repository.CategoriaRepository;
import com.weg.CategoriaProduto.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProdutoMapper mapper;

    public ProdutoRespostaDTO cadastrarProduto(ProdutoRequisicaoDTO produto){
        categoriaRepository.findById(produto.idCategoria())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));
        Produto produtoSalvo = mapper.DTOParaEntidade(produto);
        return mapper.EntidadeParaDTO(produtoRepository.save(produtoSalvo));
    }

    public List<ProdutoRespostaDTO> listarProdutos(){
        return mapper.EntidadeParaDTOList(produtoRepository.findAll());
    }

    public ProdutoRespostaDTO buscarProutoPorID(Long id){
        return mapper.EntidadeParaDTO(produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!")));
    }

    public List<ProdutoRespostaDTO> listarProdtosPorCategoria(String categoria){
        return mapper.EntidadeParaDTOList(produtoRepository.findByCategoriaNome(categoria));
    }

    public ProdutoRespostaDTO buscarProdutoPorNome(String nome){
        return mapper.EntidadeParaDTO(produtoRepository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!")));
    }

    public ProdutoRespostaDTO buscarProdutoPorIdENome(Long id, String nome){
        return mapper.EntidadeParaDTO(produtoRepository.findByIdAndNome(id, nome)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!")));
    }

    public ProdutoRespostaDTO atualizarProduto(Long id, ProdutoRequisicaoDTO produto){
        Produto produtoSalvo = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
        produtoSalvo.setNome(produto.nome());
        produtoSalvo.setCategoria(categoriaRepository.findById(produto.idCategoria())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada!")));
        return mapper.EntidadeParaDTO(produtoRepository.save(produtoSalvo));
    }

    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);
    }
}
