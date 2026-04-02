package com.weg.FuncionarioDepartamento.mapper;

import com.weg.FuncionarioDepartamento.dto.funcionario.FuncionarioRequisicaoDTO;
import com.weg.FuncionarioDepartamento.dto.funcionario.FuncionarioRespostaDTO;
import com.weg.FuncionarioDepartamento.model.Funcionario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FuncionarioMapper {

    public Funcionario DTOParaEntidade(FuncionarioRequisicaoDTO funcionario){
        return new Funcionario(
                funcionario.nome(),
                funcionario.telefone());
    }

    public FuncionarioRespostaDTO EntidadeParaDTO(Funcionario funcionario){
        return new FuncionarioRespostaDTO(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getTelefone(),
                funcionario.getDepartamento().getId());
    }

    public List<FuncionarioRespostaDTO> EntidadeParaDTOList(List<Funcionario> funcionarios){
        return funcionarios
                .stream()
                .map(this::EntidadeParaDTO)
                .toList();
    }
}
