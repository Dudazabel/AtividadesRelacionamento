package com.weg.Relacionamento_FuncionarioDepartamento.dto.funcionario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FuncionarioRespostaDTO(
        Long id,
        String nome,
        String telefone,
        Long idDepartamento
) {
}
