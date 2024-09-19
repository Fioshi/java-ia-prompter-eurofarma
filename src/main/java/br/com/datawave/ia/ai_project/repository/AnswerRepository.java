package br.com.datawave.ia.ai_project.repository;

import br.com.datawave.ia.ai_project.domain.answer.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<UserAnswer, Long> {

}
