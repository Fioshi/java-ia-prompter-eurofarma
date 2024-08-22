package br.com.datawave.ia.ai_project.domain.data;

import jakarta.validation.constraints.NotBlank;

public record MessageDto(
        @NotBlank String message) {
}
