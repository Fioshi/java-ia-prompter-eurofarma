package br.com.datawave.ia.ai_project.repository;

import br.com.datawave.ia.ai_project.domain.data.DataContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataRepository extends JpaRepository<DataContent, Long> {
    List<DataContent> findByContentContaining(String keywords);
}
