package br.com.datawave.ia.ai_project.service.ragService;

import br.com.datawave.ia.ai_project.domain.data.InputDataContent;
import br.com.datawave.ia.ai_project.domain.data.MessageDto;

public interface RagService {

    String getDataContent(MessageDto dto);

    void inputDataContent(InputDataContent input);
}
