package com.weg.ClientePedido.dto.cliente;

import jakarta.validation.constraints.NotBlank;

public record ClienteRequisicaoDTO(
        @NotBlank
        String nome,
        @NotBlank
        String endereco
) {
}
