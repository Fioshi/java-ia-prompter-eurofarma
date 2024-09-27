package br.com.datawave.ia.ai_project.domain.answer;

import br.com.datawave.ia.ai_project.domain.user.User;

public record GetAnswersDto(
        String question,
        String answer
) {
    public GetAnswersDto(UserAnswer answer) {
        this(answer.getQuestion(), answer.getAnswer());
    }

}
