package br.com.datawave.ia.ai_project.repository;

import br.com.datawave.ia.ai_project.domain.DataContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<DataContent, Long> {
}
