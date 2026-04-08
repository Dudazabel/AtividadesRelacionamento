package com.weg.FuncionarioDepartamento.controller;

import com.weg.FuncionarioDepartamento.dto.funcionario.FuncionarioRequisicaoDTO;
import com.weg.FuncionarioDepartamento.dto.funcionario.FuncionarioRespostaDTO;
import com.weg.FuncionarioDepartamento.service.FuncionarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService service;

    @PostMapping
    public ResponseEntity<FuncionarioRespostaDTO> criarFuncionario(@Valid @RequestBody FuncionarioRequisicaoDTO funcionario){
        FuncionarioRespostaDTO funcionarioSalvo = service.criarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioSalvo);
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioRespostaDTO>> listarFuncionarios(){
        return ResponseEntity.ok(service.listarTodosFuncionarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioRespostaDTO> buscarFuncionarioPorID(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarFuncionarioPorID(id));
    }

    @GetMapping("/departamento/{departamentoId}")
    public ResponseEntity<List<FuncionarioRespostaDTO>> listarFuncionariosPorDepartamento(@PathVariable Long id){
        return ResponseEntity.ok(service.listarFuncionariosPorDepartamento(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<FuncionarioRespostaDTO> buscarFuncionarioPorNome(@PathVariable String nome){
        return ResponseEntity.ok(service.buscarFuncionarioPorNome(nome));
    }

    @GetMapping("/{id}/{nome}")
    public ResponseEntity<FuncionarioRespostaDTO> buscarFuncionarioPorIdENome(@PathVariable Long id, @PathVariable String nome){
        return ResponseEntity.ok(service.buscarFuncionarioPorIdENome(id, nome));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioRespostaDTO> atualizarFuncionario(@Valid @PathVariable Long id, @RequestBody FuncionarioRequisicaoDTO funcionario){
        return ResponseEntity.ok(service.atualizarFuncionario(id, funcionario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id){
        service.deletarFuncionario(id);
        return ResponseEntity.noContent().build();
    }
}
