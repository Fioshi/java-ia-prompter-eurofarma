package br.com.datawave.ia.ai_project.service.answerService;

import br.com.datawave.ia.ai_project.Infra.Security.AuthenticateFacade;
import br.com.datawave.ia.ai_project.domain.answer.UserAnswer;
import br.com.datawave.ia.ai_project.domain.user.User;
import br.com.datawave.ia.ai_project.repository.AnswerRepository;
import br.com.datawave.ia.ai_project.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class AnswerServiceImp implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private UserService userService;


    @Override
    public void postAnswers(String dataQuestion,String dataResponse) {
        var user = userService.loadLogedUser();
        var answer = new UserAnswer(user, dataResponse, dataQuestion);
        user.addAnswer(answer);
        answerRepository.save(answer);
    }

    @Override
    public List<UserAnswer> getAnswers() {
        return List.of();
    }
}
