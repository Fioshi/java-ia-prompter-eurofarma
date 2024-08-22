package br.com.datawave.ia.ai_project.domain.data;

import br.com.datawave.ia.ai_project.domain.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_data")
public class DataContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_data")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    private String content;

    public DataContent(){

    }

    public DataContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Long getId() {
        return id;
    }
}
