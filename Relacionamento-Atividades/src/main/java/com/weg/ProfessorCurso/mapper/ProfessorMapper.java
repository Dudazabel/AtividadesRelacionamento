package com.weg.ProfessorCurso.mapper;

import com.weg.ProfessorCurso.dto.professor.ProfessorRequisicaoDTO;
import com.weg.ProfessorCurso.dto.professor.ProfessorRespostaDTO;
import com.weg.ProfessorCurso.model.Professor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfessorMapper {

    public Professor DTOParaEntidade(ProfessorRequisicaoDTO professor){
        return new Professor(professor.nome(), professor.email());
    }

    public ProfessorRespostaDTO EntidadeParaDTO(Professor professor){
        return new ProfessorRespostaDTO(professor.getId(), professor.getNome(), professor.getEmail());
    }

    public List<ProfessorRespostaDTO> EntidadeParaDTOList(List<Professor> professores){
        return professores
                .stream()
                .map(this::EntidadeParaDTO)
                .toList();
    }
}
