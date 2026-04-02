package com.weg.ClientePedido.mapper;

import com.weg.ClientePedido.dto.cliente.ClienteRequisicaoDTO;
import com.weg.ClientePedido.dto.cliente.ClienteRespostaDTO;
import com.weg.ClientePedido.model.Cliente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteMapper {

    public Cliente DTOParaEntidade(ClienteRequisicaoDTO cliente){
        return new Cliente(cliente.nome(), cliente.endereco());
    }

    public ClienteRespostaDTO EntidadeParaDTO(Cliente cliente){
        return new ClienteRespostaDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEndereco());
    }

    public List<ClienteRespostaDTO> EntidadeParaDTOList(List<Cliente> clientes){
        return clientes
                .stream()
                .map(this::EntidadeParaDTO)
                .toList();
    }
}
