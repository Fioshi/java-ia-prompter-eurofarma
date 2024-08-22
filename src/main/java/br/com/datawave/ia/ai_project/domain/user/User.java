package br.com.datawave.ia.ai_project.domain.user;

import br.com.datawave.ia.ai_project.domain.data.DataContent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "tb_user")
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    private String nome;

    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<DataContent> contents;

    public User(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public List<DataContent> getContents () {
        return Collections.unmodifiableList(this.contents);
    }
}
