package br.com.datawave.ia.ai_project.repository;

import br.com.datawave.ia.ai_project.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String subject);
}
