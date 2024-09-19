package br.com.datawave.ia.ai_project.service.answerService;

import br.com.datawave.ia.ai_project.domain.answer.UserAnswer;
import br.com.datawave.ia.ai_project.domain.user.User;

import java.util.List;

public interface AnswerService {

    void postAnswers(String data);

    List<UserAnswer> getAnswers();

}
