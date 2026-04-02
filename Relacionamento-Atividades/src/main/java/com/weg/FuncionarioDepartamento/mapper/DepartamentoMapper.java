package com.weg.FuncionarioDepartamento.mapper;

import com.weg.FuncionarioDepartamento.dto.departamento.DepartamentoRequisicaoDTO;
import com.weg.FuncionarioDepartamento.dto.departamento.DepartamentoRespostaDTO;
import com.weg.FuncionarioDepartamento.model.Departamento;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartamentoMapper {

    public Departamento DTOParaEntidade(DepartamentoRequisicaoDTO departamento){
        return new Departamento(departamento.nome(), departamento.nomeGestor());
    }

    public DepartamentoRespostaDTO EntidadeParaDTO(Departamento departamento){
        return new DepartamentoRespostaDTO(departamento.getId(), departamento.getNome(), departamento.getNomeGestor());
    }

    public List<DepartamentoRespostaDTO> EntidadeParaDTOList(List<Departamento> departamentos){
        return departamentos.stream()
                .map(this::EntidadeParaDTO)
                .toList();
    }
}
