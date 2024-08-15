package br.com.datawave.ia.ai_project.service;

import br.com.datawave.ia.ai_project.controller.MessageDto;
import org.springframework.stereotype.Service;

@Service
public interface RagService {

    String getDataContent(MessageDto dto);
}
