package com.weg.CategoriaProduto.dto.categoria;

import jakarta.validation.constraints.NotBlank;

public record CategoriaRequisicaoDTO(
        @NotBlank
        String nome,
        @NotBlank
        String descricao
) {
}
