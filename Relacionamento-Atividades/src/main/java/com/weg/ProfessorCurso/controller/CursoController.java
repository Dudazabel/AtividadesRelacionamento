package com.weg.ProfessorCurso.controller;

import com.weg.ProfessorCurso.dto.curso.CursoRequisicaoDTO;
import com.weg.ProfessorCurso.dto.curso.CursoRespostaDTO;
import com.weg.ProfessorCurso.service.CursoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/curso")
public class CursoController {

    private final CursoService service;

    @PostMapping
    public ResponseEntity<CursoRespostaDTO> cadastrarCurso(@Valid @RequestBody CursoRequisicaoDTO curso){
        CursoRespostaDTO cursoSalvo = service.cadastrarCurso(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<CursoRespostaDTO>> listarCursos(){
        return ResponseEntity.ok(service.listarCursos());
    }

    @GetMapping("/Professor/{id}")
    public ResponseEntity<List<CursoRespostaDTO>> listaCursosIdProfessor(@PathVariable Long id){
        return ResponseEntity.ok(service.listarCursosIdProfessor(id));
    }

    @GetMapping("/Professor/{nome}")
    public ResponseEntity<List<CursoRespostaDTO>> listaCursosNomeProfessor(@PathVariable String nome){
        return ResponseEntity.ok(service.listarCursoNomeProfessor(nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoRespostaDTO> buscarCursoPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarCursoPorId(id));
    }

    @GetMapping("/{id}/{nome}")
    public ResponseEntity<CursoRespostaDTO> buscarCursoPorIdENome(@PathVariable Long id, @PathVariable String nome){
        return ResponseEntity.ok(service.buscarCursoPorIdENome(id, nome));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoRespostaDTO> atualizarCurso(@Valid @PathVariable Long id, @RequestBody CursoRequisicaoDTO curso){
        return ResponseEntity.ok(service.atualizarCurso(curso, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCurso(@PathVariable Long id){
        service.deletarCurso(id);
        return ResponseEntity.noContent().build();
    }
}
