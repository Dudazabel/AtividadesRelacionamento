package com.weg.Relacionamento_FuncionarioDepartamento.service;

import com.weg.Relacionamento_FuncionarioDepartamento.dto.funcionario.FuncionarioRequisicaoDTO;
import com.weg.Relacionamento_FuncionarioDepartamento.dto.funcionario.FuncionarioRespostaDTO;
import com.weg.Relacionamento_FuncionarioDepartamento.mapper.FuncionarioMapper;
import com.weg.Relacionamento_FuncionarioDepartamento.model.Departamento;
import com.weg.Relacionamento_FuncionarioDepartamento.model.Funcionario;
import com.weg.Relacionamento_FuncionarioDepartamento.repository.DepartamentoRepository;
import com.weg.Relacionamento_FuncionarioDepartamento.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final DepartamentoRepository departamentoRepository;
    private final FuncionarioMapper mapper;

    public FuncionarioRespostaDTO criarFuncionario(FuncionarioRequisicaoDTO funcionario){

        Departamento departamento = departamentoRepository.findById(funcionario.idDepartamento())
                .orElseThrow(() -> new RuntimeException("O departamento informado não foi encontrado!"));
        Funcionario funcionarioSalvo = mapper.DTOParaEntidade(funcionario);
        return mapper.EntidadeParaDTO(funcionarioRepository.save(funcionarioSalvo));
    }
    
}
