package br.com.datawave.ia.ai_project.domain.user;

import br.com.datawave.ia.ai_project.domain.data.DataContent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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

    private String username;

    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<DataContent> contents = new LinkedList<>();

    public User(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public List<DataContent> getContents () {
        return Collections.unmodifiableList(this.contents);
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
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
        return this.username;
    }

    public void addData(DataContent dataContent){
        this.contents.add(dataContent);
    }

    public void removeData(DataContent dataContent){
        this.contents.remove(dataContent);
    }
}
