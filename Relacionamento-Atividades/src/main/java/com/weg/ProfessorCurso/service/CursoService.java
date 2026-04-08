package com.weg.ProfessorCurso.service;

import com.weg.ProfessorCurso.dto.curso.CursoRequisicaoDTO;
import com.weg.ProfessorCurso.dto.curso.CursoRespostaDTO;
import com.weg.ProfessorCurso.mapper.CursoMapper;
import com.weg.ProfessorCurso.model.Curso;
import com.weg.ProfessorCurso.model.Professor;
import com.weg.ProfessorCurso.repository.CursoRepository;
import com.weg.ProfessorCurso.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;
    private final CursoMapper cursoMapper;
    private final ProfessorRepository professorRepository;

    public CursoRespostaDTO cadastrarCurso(CursoRequisicaoDTO curso){
        Professor professor = professorRepository.findById(curso.idProfessor())
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        Curso cursoSalvo = cursoMapper.DTOParaEntidade(curso);
        return cursoMapper.EntidadeParaDTO(cursoRepository.save(cursoSalvo));
    }

    public List<CursoRespostaDTO> listarCursos(){
        return cursoMapper.EntidadeParaDTOList(cursoRepository.findAll());
    }

    public List<CursoRespostaDTO> listarCursosIdProfessor(Long id){
        return cursoMapper.EntidadeParaDTOList(cursoRepository.findByProfessorId(id));
    }

    public List<CursoRespostaDTO> listarCursoNomeProfessor(String nome){
        return cursoMapper.EntidadeParaDTOList(cursoRepository.findByProfessorNome(nome));
    }

    public CursoRespostaDTO buscarCursoPorId(Long id){
        return cursoMapper.EntidadeParaDTO(cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado!")));
    }

    public CursoRespostaDTO buscarCursoPorIdENome(Long id, String nome){
        return cursoMapper.EntidadeParaDTO(cursoRepository.findByIdAndNome(id, nome)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado!")));
    }

    public CursoRespostaDTO atualizarCurso(CursoRequisicaoDTO curso, Long id){
        Curso cursoSalvo = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado!"));
        cursoSalvo.setNome(curso.nome());
        cursoSalvo.setSala(curso.sala());
        cursoSalvo.setProfessor(professorRepository.findById(curso.idProfessor())
                .orElseThrow(() -> new RuntimeException("Professor não encontrado!")));
        return cursoMapper.EntidadeParaDTO(cursoRepository.save(cursoSalvo));
    }

    public void deletarCurso(Long id){
        cursoRepository.deleteById(id);
    }
}
