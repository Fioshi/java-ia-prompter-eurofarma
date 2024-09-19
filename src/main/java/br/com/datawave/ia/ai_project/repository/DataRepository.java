package br.com.datawave.ia.ai_project.repository;

import br.com.datawave.ia.ai_project.domain.data.DataContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DataRepository extends JpaRepository<DataContent, Long> {

    @Query("SELECT d FROM DataContent d WHERE d.content IN :keywords")
    List<DataContent> findAllByKeywords(@Param("keywords") List<String> keywords);
}

