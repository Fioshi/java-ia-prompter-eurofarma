package br.com.datawave.ia.ai_project.domain.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DescribeUserDto(
        @NotNull Long id,
        @NotBlank String nome,
        @NotBlank String email
) {
}
