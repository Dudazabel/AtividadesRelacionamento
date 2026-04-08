package com.weg.ProfessorCurso.controller;

import com.weg.ProfessorCurso.dto.professor.ProfessorRequisicaoDTO;
import com.weg.ProfessorCurso.dto.professor.ProfessorRespostaDTO;
import com.weg.ProfessorCurso.service.ProfessorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService service;

    @PostMapping
    public ResponseEntity<ProfessorRespostaDTO> cadastrarProfessor(@Valid @RequestBody ProfessorRequisicaoDTO professor){
        ProfessorRespostaDTO professorSalvo = service.cadastrarProfessor(professor);
        return ResponseEntity.status(HttpStatus.CREATED).body(professorSalvo);
    }

    @GetMapping
    public ResponseEntity<List<ProfessorRespostaDTO>> listarProfessor(){
        return ResponseEntity.ok(service.listarProfessores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorRespostaDTO> buscaProfessorPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarProfessorPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorRespostaDTO> atualizarProfessor(@Valid @PathVariable Long id, @RequestBody ProfessorRequisicaoDTO professor){
        return ResponseEntity.ok(service.atualizarProfessorPorId(professor, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProfessor(@PathVariable Long id){
        service.deletarProfessor(id);
        return ResponseEntity.noContent().build();
    }
}
