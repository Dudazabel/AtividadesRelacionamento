package com.weg.ProfessorCurso.service;

import com.weg.CategoriaProduto.dto.produto.ProdutoRespostaDTO;
import com.weg.ProfessorCurso.dto.professor.ProfessorRequisicaoDTO;
import com.weg.ProfessorCurso.dto.professor.ProfessorRespostaDTO;
import com.weg.ProfessorCurso.mapper.ProfessorMapper;
import com.weg.ProfessorCurso.model.Professor;
import com.weg.ProfessorCurso.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorMapper mapper;
    private final ProfessorRepository repository;

    public ProfessorRespostaDTO cadastrarProfessor(ProfessorRequisicaoDTO professor){
        Professor professorSalvo = mapper.DTOParaEntidade(professor);
        return mapper.EntidadeParaDTO(repository.save(professorSalvo));
    }

    public List<ProfessorRespostaDTO> listarProfessores(){
        return mapper.EntidadeParaDTOList(repository.findAll());
    }

    public ProfessorRespostaDTO buscarProfessorPorId(Long id){
        return mapper.EntidadeParaDTO(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado!")));
    }

    public ProfessorRespostaDTO atualizarProfessorPorId(ProfessorRequisicaoDTO professor, Long id){
        Professor professorSalvo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado!"));
        professorSalvo.setNome(professor.nome());
        professorSalvo.setEmail(professor.email());
        return mapper.EntidadeParaDTO(repository.save(professorSalvo));
    }

    public void deletarProfessor(Long id){
        repository.deleteById(id);
    }
}
