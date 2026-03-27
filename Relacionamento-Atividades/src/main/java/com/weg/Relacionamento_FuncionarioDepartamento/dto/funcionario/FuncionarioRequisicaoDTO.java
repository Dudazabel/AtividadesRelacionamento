package com.weg.Relacionamento_FuncionarioDepartamento.dto.funcionario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FuncionarioRequisicaoDTO(
        @NotBlank
        String nome,
        @NotBlank
        String telefone,
        @NotNull
        Long idDepartamento
) {
}
