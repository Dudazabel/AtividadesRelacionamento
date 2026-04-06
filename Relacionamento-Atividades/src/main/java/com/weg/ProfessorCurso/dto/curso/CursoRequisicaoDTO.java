package com.weg.ProfessorCurso.dto.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CursoRequisicaoDTO(
        @NotBlank
        String nome,
        @NotBlank
        String sala,
        @NotNull
        Long idProfessor
) {
}
