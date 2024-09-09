package br.com.datawave.ia.ai_project.domain.user;

import jakarta.validation.constraints.NotBlank;

public record UserLoginDto(
        @NotBlank String email,
        @NotBlank String password
) {
}
