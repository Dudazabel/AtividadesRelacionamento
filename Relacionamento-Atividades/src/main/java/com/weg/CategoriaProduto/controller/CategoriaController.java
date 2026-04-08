package com.weg.CategoriaProduto.controller;

import com.weg.CategoriaProduto.dto.categoria.CategoriaRequisicaoDTO;
import com.weg.CategoriaProduto.dto.categoria.CategoriaRespostaDTO;
import com.weg.CategoriaProduto.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService service;

    @PostMapping
    public ResponseEntity<CategoriaRespostaDTO> cadastrarCategoria(@Valid @RequestBody CategoriaRequisicaoDTO categoria){
        CategoriaRespostaDTO categoriaSalvo = service.cadastrarCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalvo);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaRespostaDTO>> listarCategorias(){
        return ResponseEntity.ok(service.listarCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaRespostaDTO> buscarCategoriaPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarCategoriaPorID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaRespostaDTO> atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaRequisicaoDTO categoria){
        return ResponseEntity.ok(service.atualizarCategoria(id, categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id){
        service.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
