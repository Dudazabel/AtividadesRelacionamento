package com.weg.ClientePedido.dto.pedido;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PedidoRequisicaoDTO(
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @NotNull
        Long idCliente
) {
}
