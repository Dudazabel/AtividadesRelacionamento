package com.weg.ClientePedido.service;

import com.weg.ClientePedido.dto.cliente.ClienteRequisicaoDTO;
import com.weg.ClientePedido.dto.cliente.ClienteRespostaDTO;
import com.weg.ClientePedido.mapper.ClienteMapper;
import com.weg.ClientePedido.model.Cliente;
import com.weg.ClientePedido.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteMapper mapper;
    private final ClienteRepository repository;

    public ClienteRespostaDTO cadastrarCliente(ClienteRequisicaoDTO cliente){
        Cliente clienteSalvo = mapper.DTOParaEntidade(cliente);
        return mapper.EntidadeParaDTO(repository.save(clienteSalvo));
    }

    public List<ClienteRespostaDTO> listarClientes(){
        return mapper.EntidadeParaDTOList(repository.findAll());
    }

    public ClienteRespostaDTO buscarClientePorId(Long id){
        return mapper.EntidadeParaDTO(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado!")));
    }

    public ClienteRespostaDTO buscarClientePorIdENome(Long id, String nome){
        return mapper.EntidadeParaDTO(repository.findByIdAndNome(id, nome)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado!")));
    }

    public ClienteRespostaDTO atualizarCliente(Long id, ClienteRequisicaoDTO cliente){
        Cliente clienteSalvo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        clienteSalvo.setNome(cliente.nome());
        clienteSalvo.setEndereco(cliente.endereco());
        return mapper.EntidadeParaDTO(repository.save(clienteSalvo));
    }

    public void deletarCliente(Long id){
        repository.deleteById(id);
    }
}
