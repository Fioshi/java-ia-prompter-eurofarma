package br.com.datawave.ia.ai_project.Infra.Security;

public record TokenReturn(
        Long idUser,
        String nameUser,
        String token
) {
}
