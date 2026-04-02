package com.weg.FuncionarioDepartamento.controller;

import com.weg.FuncionarioDepartamento.dto.funcionario.FuncionarioRequisicaoDTO;
import com.weg.FuncionarioDepartamento.dto.funcionario.FuncionarioRespostaDTO;
import com.weg.FuncionarioDepartamento.service.FuncionarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService service;

    @PostMapping
    public FuncionarioRespostaDTO criarFuncionario(@Valid @RequestBody FuncionarioRequisicaoDTO funcionario){
        return service.criarFuncionario(funcionario);
    }

    @GetMapping
    public List<FuncionarioRespostaDTO> listarFuncionarios(){
        return service.listarTodosFuncionarios();
    }

    @GetMapping("/{id}")
    public FuncionarioRespostaDTO buscarFuncionarioPorID(@Valid @PathVariable Long id){
        return service.buscarFuncionarioPorID(id);
    }

    @GetMapping("/departamento/{departamentoId}")
    public List<FuncionarioRespostaDTO> listarFuncionariosPorDepartamento(@Valid @PathVariable Long id){
        return service.listarFuncionariosPorDepartamento(id);
    }

    @GetMapping("/nome/{nome}")
    public FuncionarioRespostaDTO buscarFuncionarioPorNome(@Valid @PathVariable String nome){
        return service.buscarFuncionarioPorNome(nome);
    }

    @GetMapping("/{id}/{nome}")
    public FuncionarioRespostaDTO buscarFuncionarioPorIdENome(@Valid @PathVariable Long id, @PathVariable String nome){
        return service.buscarFuncionarioPorIdENome(id, nome);
    }

    @PutMapping("/{id}")
    public FuncionarioRespostaDTO atualizarFuncionario(@Valid @PathVariable Long id, @RequestBody FuncionarioRequisicaoDTO funcionario){
        return service.atualizarFuncionario(id, funcionario);
    }

    @DeleteMapping("/{id}")
    public void deletarFuncionario(@Valid @PathVariable Long id){
        service.deletarFuncionario(id);
    }
}
