package com.weg.CategoriaProduto.controller;

import com.weg.CategoriaProduto.dto.produto.ProdutoRequisicaoDTO;
import com.weg.CategoriaProduto.dto.produto.ProdutoRespostaDTO;
import com.weg.CategoriaProduto.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ResponseEntity<ProdutoRespostaDTO> cadastrarProduto(@Valid @RequestBody ProdutoRequisicaoDTO produto){
        ProdutoRespostaDTO produtoSalvo = service.cadastrarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoRespostaDTO>> listarProduto(){
        return ResponseEntity.ok(service.listarProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoRespostaDTO> buscarProdutoPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarProutoPorID(id));
    }

    @GetMapping("/categoriaNome/{categoria}")
    public ResponseEntity<List<ProdutoRespostaDTO>> listarProdutosPorCategoria(@PathVariable String categoria){
        return ResponseEntity.ok(service.listarProdtosPorCategoria(categoria));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<ProdutoRespostaDTO> buscarProdutoPorNome(@PathVariable String nome){
        return ResponseEntity.ok(service.buscarProdutoPorNome(nome));
    }

    @GetMapping("/{id}/{nome}")
    public ResponseEntity<ProdutoRespostaDTO> buscarProdutoPorIdENome(@PathVariable Long id, @PathVariable String nome){
        return ResponseEntity.ok(service.buscarProdutoPorIdENome(id, nome));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoRespostaDTO> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoRequisicaoDTO produto){
        return ResponseEntity.ok(service.atualizarProduto(id, produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
        service.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
