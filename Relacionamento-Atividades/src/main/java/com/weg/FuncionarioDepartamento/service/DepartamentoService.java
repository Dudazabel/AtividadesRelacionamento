package com.weg.FuncionarioDepartamento.service;

import com.weg.FuncionarioDepartamento.dto.departamento.DepartamentoRequisicaoDTO;
import com.weg.FuncionarioDepartamento.dto.departamento.DepartamentoRespostaDTO;
import com.weg.FuncionarioDepartamento.mapper.DepartamentoMapper;
import com.weg.FuncionarioDepartamento.model.Departamento;
import com.weg.FuncionarioDepartamento.repository.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartamentoService {

    private final DepartamentoRepository repository;
    private final DepartamentoMapper mapper;

    public DepartamentoRespostaDTO criarDepartamento(DepartamentoRequisicaoDTO departamento){
        Departamento departamentoSalvo = mapper.DTOParaEntidade(departamento);
        return mapper.EntidadeParaDTO(repository.save(departamentoSalvo));
    }

    public List<DepartamentoRespostaDTO> listarTodosDepartamentos(){
        return mapper.EntidadeParaDTOList(repository.findAll());
    }

    public DepartamentoRespostaDTO procurarDepartamentoPorID(Long id){
        return mapper.EntidadeParaDTO(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("O ID solicitado não foi encontrado!")));
    }

    public DepartamentoRespostaDTO atualizarDepartamentoPorID(DepartamentoRequisicaoDTO departamento, Long id){
        Departamento departamentoSalvo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("O ID solicitado não foi encontrado"));
        departamentoSalvo.setNome(departamento.nome());
        departamentoSalvo.setNomeGestor(departamento.nomeGestor());
        return mapper.EntidadeParaDTO(repository.save(departamentoSalvo));
    }

    public void deletarDepartamento(Long id){
        repository.deleteById(id);
    }
}
