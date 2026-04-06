package com.weg.ProfessorCurso.mapper;

import com.weg.ProfessorCurso.dto.curso.CursoRequisicaoDTO;
import com.weg.ProfessorCurso.dto.curso.CursoRespostaDTO;
import com.weg.ProfessorCurso.model.Curso;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CursoMapper {

    public Curso DTOParaEntidade(CursoRequisicaoDTO curso){
        return new Curso(curso.nome(), curso.sala());
    }

    public CursoRespostaDTO EntidadeParaDTO(Curso curso){
        return new CursoRespostaDTO(curso.getId(), curso.getNome(), curso.getSala(), curso.getProfessor().getId());
    }

    public List<CursoRespostaDTO> EntidadeParaDTOList(List<Curso> cursos){
        return cursos
                .stream()
                .map(this::EntidadeParaDTO)
                .toList();
    }
}
