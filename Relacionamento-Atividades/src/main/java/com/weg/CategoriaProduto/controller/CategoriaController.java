package com.weg.CategoriaProduto.controller;

import com.weg.CategoriaProduto.dto.categoria.CategoriaRequisicaoDTO;
import com.weg.CategoriaProduto.dto.categoria.CategoriaRespostaDTO;
import com.weg.CategoriaProduto.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService service;

    @PostMapping
    public CategoriaRespostaDTO cadastrarCategoria(@Valid @RequestBody CategoriaRequisicaoDTO categoria){
        return service.cadastrarCategoria(categoria);
    }

    @GetMapping
    public List<CategoriaRespostaDTO> listarCategorias(){
        return service.listarCategorias();
    }

    @GetMapping("/{id}")
    public CategoriaRespostaDTO buscarCategoriaPorId(@Valid @PathVariable Long id){
        return service.buscarCategoriaPorID(id);
    }

    @PutMapping("/{id}")
    public CategoriaRespostaDTO atualizarCategoria(@Valid @PathVariable Long id, @RequestBody CategoriaRequisicaoDTO categoria){
        return service.atualizarCategoria(id, categoria);
    }

    @DeleteMapping("/{id}")
    public void deletarCategoria(@Valid @PathVariable Long id){
        service.deletarCategoria(id);
    }
}
