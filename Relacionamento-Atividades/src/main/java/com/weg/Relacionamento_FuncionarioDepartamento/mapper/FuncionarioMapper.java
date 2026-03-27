package com.weg.Relacionamento_FuncionarioDepartamento.mapper;

import com.weg.Relacionamento_FuncionarioDepartamento.dto.funcionario.FuncionarioRequisicaoDTO;
import com.weg.Relacionamento_FuncionarioDepartamento.dto.funcionario.FuncionarioRespostaDTO;
import com.weg.Relacionamento_FuncionarioDepartamento.model.Funcionario;
import org.springframework.stereotype.Component;

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
}
