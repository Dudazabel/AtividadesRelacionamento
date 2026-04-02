package com.weg.FuncionarioDepartamento.controller;

import com.weg.FuncionarioDepartamento.dto.departamento.DepartamentoRequisicaoDTO;
import com.weg.FuncionarioDepartamento.dto.departamento.DepartamentoRespostaDTO;
import com.weg.FuncionarioDepartamento.service.DepartamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
@RequiredArgsConstructor
public class DepartamentoController {

    private final DepartamentoService service;

    @PostMapping
    public DepartamentoRespostaDTO criarDepartamento(@RequestBody DepartamentoRequisicaoDTO departamento){
        return service.criarDepartamento(departamento);
    }

    @GetMapping
    public List<DepartamentoRespostaDTO> listarTodosDepartamentos(){
        return service.listarTodosDepartamentos();
    }

    @GetMapping("/{id}")
    public DepartamentoRespostaDTO procurarDepartamentoPorID(@PathVariable Long id){
        return service.procurarDepartamentoPorID(id);
    }

    @PutMapping("/{id}")
    public DepartamentoRespostaDTO atualizarDepartamentoPorID(@RequestBody DepartamentoRequisicaoDTO departamento, @PathVariable Long id){
        return service.atualizarDepartamentoPorID(departamento, id);
    }

    @DeleteMapping("/{id}")
    public void deletarDepartamento(@PathVariable Long id){
        service.deletarDepartamento(id);
    }
}
