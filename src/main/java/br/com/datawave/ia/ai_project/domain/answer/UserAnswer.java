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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    private String answer;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    public UserAnswer(User user, String data, String question) {
        this.answer = data;
        this.question = question;
        this.user = user;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
