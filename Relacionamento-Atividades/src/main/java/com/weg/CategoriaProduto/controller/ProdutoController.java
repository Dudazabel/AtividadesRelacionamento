package com.weg.CategoriaProduto.controller;

import com.weg.CategoriaProduto.dto.produto.ProdutoRequisicaoDTO;
import com.weg.CategoriaProduto.dto.produto.ProdutoRespostaDTO;
import com.weg.CategoriaProduto.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ProdutoRespostaDTO cadastrarProduto(@Valid @RequestBody ProdutoRequisicaoDTO produto){
        return service.cadastrarProduto(produto);
    }

    @GetMapping
    public List<ProdutoRespostaDTO> listarProduto(){
        return service.listarProdutos();
    }

    @GetMapping("/{id}")
    public ProdutoRespostaDTO buscarProdutoPorId(@Valid @PathVariable Long id){
        return service.buscarProutoPorID(id);
    }

    @GetMapping("/categoriaNome/{categoria}")
    public List<ProdutoRespostaDTO> listarProdutosPorCategoria(@Valid @PathVariable String categoria){
        return service.listarProdtosPorCategoria(categoria);
    }

    @GetMapping("/nome/{nome}")
    public ProdutoRespostaDTO buscarProdutoPorNome(@Valid @PathVariable String nome){
        return service.buscarProdutoPorNome(nome);
    }

    @GetMapping("/{id}/{nome}")
    public ProdutoRespostaDTO buscarProdutoPorIdENome(@Valid @PathVariable Long id, @PathVariable String nome){
        return service.buscarProdutoPorIdENome(id, nome);
    }

    @PutMapping("/{id}")
    public ProdutoRespostaDTO atualizarProduto(@Valid @PathVariable Long id, @RequestBody ProdutoRequisicaoDTO produto){
        return service.atualizarProduto(id, produto);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@Valid @PathVariable Long id){
        service.deletarProduto(id);
    }
}
