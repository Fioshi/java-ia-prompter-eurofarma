package br.com.datawave.ia.ai_project.domain;

import jakarta.validation.constraints.NotBlank;

public record MessageDto(
        @NotBlank String message) {
}
