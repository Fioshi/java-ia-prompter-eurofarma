package br.com.datawave.ia.ai_project.domain.answer;

import br.com.datawave.ia.ai_project.domain.user.User;

public record InsertAnswerDto(
        String answer,
        User user
) {
}
