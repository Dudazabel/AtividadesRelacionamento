package com.weg.ProfessorCurso.dto.professor;

import jakarta.validation.constraints.NotBlank;

public record ProfessorRequisicaoDTO(
        @NotBlank
        String nome,
        @NotBlank
        String email
) {
}
