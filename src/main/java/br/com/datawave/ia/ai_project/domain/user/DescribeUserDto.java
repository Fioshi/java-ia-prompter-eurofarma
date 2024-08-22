package br.com.datawave.ia.ai_project.domain.user;

import br.com.datawave.ia.ai_project.domain.data.DataContent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DescribeUserDto(
        @NotNull Long id,
        @NotBlank String nome,
        @NotBlank String email,
        List<DataContent> contents
        ) {
}
