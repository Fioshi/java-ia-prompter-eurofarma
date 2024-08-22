package br.com.datawave.ia.ai_project.domain.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InsertUserDto(
        @NotBlank String nome ,
        @NotBlank String email
) {
}
