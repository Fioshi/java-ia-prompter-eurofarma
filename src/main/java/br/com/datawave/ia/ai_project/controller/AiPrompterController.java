package br.com.datawave.ia.ai_project.controller;

import br.com.datawave.ia.ai_project.factory.AiAssistentFactory;
import br.com.datawave.ia.ai_project.factory.ContentRetrieverFactory;
import br.com.datawave.ia.ai_project.factory.DocumentAssistantFactory;
import br.com.datawave.ia.ai_project.factory.EmbeddingFactory;
import br.com.datawave.ia.ai_project.service.RagService;
import dev.langchain4j.model.chat.ChatLanguageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ai/chat")
public class AiPrompterController {

    @Value("${langchain.huggingface.accessToken}")
    private String token;

    @Autowired
    private RagService service;

    @PostMapping
    public ResponseEntity chat(@RequestBody MessageDto messageDTO){
        var response = service.getDataContent(messageDTO);
        return ResponseEntity.ok().body(response);
    }
}
