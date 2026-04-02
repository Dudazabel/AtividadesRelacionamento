package com.weg.FuncionarioDepartamento.dto.departamento;

import jakarta.validation.constraints.NotBlank;

public record DepartamentoRequisicaoDTO(
        @NotBlank
        String nome,
        @NotBlank
        String nomeGestor
) {
}
