package br.com.datawave.ia.ai_project.service;

import br.com.datawave.ia.ai_project.domain.InputDataContent;
import br.com.datawave.ia.ai_project.domain.MessageDto;

public interface RagService {

    String getDataContent(MessageDto dto);

    void inputDataContent(InputDataContent input);
}
