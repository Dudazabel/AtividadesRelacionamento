package com.weg.Relacionamento_FuncionarioDepartamento.dto.departamento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DepartamentoRespostaDTO(
        Long id,
        String nome,
        String nomeGestor
) {
}
