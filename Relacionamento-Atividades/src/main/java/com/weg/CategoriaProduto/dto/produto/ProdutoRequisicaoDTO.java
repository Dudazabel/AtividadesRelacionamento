package com.weg.CategoriaProduto.dto.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoRequisicaoDTO(
        @NotBlank
        String nome,
        @NotNull
        Long idCategoria
) {
}
