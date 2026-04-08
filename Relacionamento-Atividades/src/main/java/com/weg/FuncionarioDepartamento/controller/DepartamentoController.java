package com.weg.FuncionarioDepartamento.controller;

import com.weg.FuncionarioDepartamento.dto.departamento.DepartamentoRequisicaoDTO;
import com.weg.FuncionarioDepartamento.dto.departamento.DepartamentoRespostaDTO;
import com.weg.FuncionarioDepartamento.service.DepartamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
@RequiredArgsConstructor
public class DepartamentoController {

    private final DepartamentoService service;

    @PostMapping
    public ResponseEntity<DepartamentoRespostaDTO> criarDepartamento(@RequestBody DepartamentoRequisicaoDTO departamento){
        DepartamentoRespostaDTO departamentoSalvo = service.criarDepartamento(departamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(departamentoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoRespostaDTO>> listarTodosDepartamentos(){
        return ResponseEntity.ok(service.listarTodosDepartamentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoRespostaDTO> procurarDepartamentoPorID(@PathVariable Long id){
        return ResponseEntity.ok(service.procurarDepartamentoPorID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoRespostaDTO> atualizarDepartamentoPorID(@RequestBody DepartamentoRequisicaoDTO departamento, @PathVariable Long id){
        return ResponseEntity.ok(service.atualizarDepartamentoPorID(departamento, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDepartamento(@PathVariable Long id){
        service.deletarDepartamento(id);
        return ResponseEntity.noContent().build();
    }
}
