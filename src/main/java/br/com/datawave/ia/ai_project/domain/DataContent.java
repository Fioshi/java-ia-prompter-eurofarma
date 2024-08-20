package br.com.datawave.ia.ai_project.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_data")
public class DataContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

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
