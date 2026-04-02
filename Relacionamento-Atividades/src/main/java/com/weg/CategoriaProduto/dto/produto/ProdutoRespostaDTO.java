package com.weg.CategoriaProduto.dto.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoRespostaDTO(
        Long id,
        String nome,
        Long idCategoria
) {
}
