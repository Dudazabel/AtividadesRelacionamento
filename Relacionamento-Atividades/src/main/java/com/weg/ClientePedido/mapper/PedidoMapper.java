package com.weg.ClientePedido.mapper;

import com.weg.ClientePedido.dto.pedido.PedidoRequisicaoDTO;
import com.weg.ClientePedido.dto.pedido.PedidoRespostaDTO;
import com.weg.ClientePedido.model.Pedido;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoMapper {

    public Pedido DTOParaEntidade(PedidoRequisicaoDTO pedido){
        return new Pedido(
                pedido.nome(),
                pedido.descricao());
    }

    public PedidoRespostaDTO EntidadeParaDTO(Pedido pedido){
        return new PedidoRespostaDTO(
                pedido.getId(),
                pedido.getNome(),
                pedido.getDescricao(),
                pedido.getCliente().getId());
    }

    public List<PedidoRespostaDTO> EntidadeParaDTOList(List<Pedido> pedidos){
        return pedidos
                .stream()
                .map(this::EntidadeParaDTO)
                .toList();
    }
}
