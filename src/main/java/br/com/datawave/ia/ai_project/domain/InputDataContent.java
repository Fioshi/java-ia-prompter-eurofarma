package br.com.datawave.ia.ai_project.domain;

import jakarta.validation.constraints.NotBlank;

public record InputDataContent(
        @NotBlank String content
) {
}
