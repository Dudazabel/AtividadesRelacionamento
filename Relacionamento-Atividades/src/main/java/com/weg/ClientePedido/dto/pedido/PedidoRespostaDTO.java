package com.weg.ClientePedido.dto.pedido;

public record PedidoRespostaDTO(
        Long id,
        String nome,
        String descricao,
        Long idCliente
) {
}
