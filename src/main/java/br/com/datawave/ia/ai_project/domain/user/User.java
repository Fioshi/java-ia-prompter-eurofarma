package br.com.datawave.ia.ai_project.domain.user;

import br.com.datawave.ia.ai_project.domain.answer.UserAnswer;
import br.com.datawave.ia.ai_project.domain.data.DataContent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    private String nome;

    private String email;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<UserAnswer> answers = new LinkedList<>();

    public User(String nome, String email, String password) {
        this.nome = nome;
        this.email = email;
        this.password = cript(password);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    public List<UserAnswer> getAnswers(){
        return Collections.unmodifiableList(this.answers);
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void addAnswer(UserAnswer answer){
        this.answers.add(answer);
    }

    private String cript(String password){
        return new BCryptPasswordEncoder().encode(password);
    }
}
