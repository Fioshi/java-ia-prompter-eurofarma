package br.com.datawave.ia.ai_project.domain.answer;

import br.com.datawave.ia.ai_project.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_answer")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserAnswer {

    @Id
    @Column(name = "id_answer")
    private Long id;

    private String answer;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    public UserAnswer(User user, String data) {
        this.answer = data;
        this.user = user;
    }
}
