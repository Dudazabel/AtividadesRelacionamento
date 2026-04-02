package com.weg.FuncionarioDepartamento.dto.funcionario;

public record FuncionarioRespostaDTO(
        Long id,
        String nome,
        String telefone,
        Long idDepartamento
) {
}
