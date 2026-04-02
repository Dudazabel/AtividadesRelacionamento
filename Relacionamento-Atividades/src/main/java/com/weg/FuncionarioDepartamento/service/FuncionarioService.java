package com.weg.FuncionarioDepartamento.service;

import com.weg.FuncionarioDepartamento.dto.funcionario.FuncionarioRequisicaoDTO;
import com.weg.FuncionarioDepartamento.dto.funcionario.FuncionarioRespostaDTO;
import com.weg.FuncionarioDepartamento.mapper.FuncionarioMapper;
import com.weg.FuncionarioDepartamento.model.Departamento;
import com.weg.FuncionarioDepartamento.model.Funcionario;
import com.weg.FuncionarioDepartamento.repository.DepartamentoRepository;
import com.weg.FuncionarioDepartamento.repository.FuncionarioRepository;
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

    public List<FuncionarioRespostaDTO> listarTodosFuncionarios(){
        return mapper.EntidadeParaDTOList(funcionarioRepository.findAll());
    }

    public  FuncionarioRespostaDTO buscarFuncionarioPorID(Long id){
        return mapper.EntidadeParaDTO(funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado!")));
    }

    public List<FuncionarioRespostaDTO> listarFuncionariosPorDepartamento(Long id){
        return mapper.EntidadeParaDTOList(funcionarioRepository.findByDepartamentoId(id));
    }

    public FuncionarioRespostaDTO buscarFuncionarioPorNome(String nome){
        return mapper.EntidadeParaDTO(funcionarioRepository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado!")));
    }

    public FuncionarioRespostaDTO buscarFuncionarioPorIdENome(Long id, String nome){
        return mapper.EntidadeParaDTO(funcionarioRepository.findByIdAndNome(id, nome)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado!")));
    }

    public FuncionarioRespostaDTO atualizarFuncionario(Long id, FuncionarioRequisicaoDTO funcionario){
        Funcionario funcionarioSalvo = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));
        funcionarioSalvo.setNome(funcionario.nome());
        funcionarioSalvo.setTelefone(funcionario.telefone());
        funcionarioSalvo.setDepartamento(departamentoRepository.findById(funcionario.idDepartamento())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado!")));
        return mapper.EntidadeParaDTO(funcionarioRepository.save(funcionarioSalvo));
    }

    public void deletarFuncionario(Long id){
        funcionarioRepository.deleteById(id);
    }
}
