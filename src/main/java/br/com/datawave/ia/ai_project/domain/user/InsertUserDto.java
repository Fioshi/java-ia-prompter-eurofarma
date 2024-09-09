package br.com.datawave.ia.ai_project.domain.user;

import jakarta.validation.constraints.NotBlank;

public record InsertUserDto(
        @NotBlank String nome ,
        @NotBlank String email,
        @NotBlank String password
) {
}
