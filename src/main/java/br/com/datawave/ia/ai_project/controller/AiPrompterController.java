package br.com.datawave.ia.ai_project.controller;

import br.com.datawave.ia.ai_project.domain.data.MessageDto;
import br.com.datawave.ia.ai_project.service.ragService.RagService;
import jakarta.validation.Valid;
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
    public ResponseEntity<String> chat(@Valid @RequestBody MessageDto messageDTO){
        var response = service.getDataContent(messageDTO);
        return ResponseEntity.ok().body(response);
    }
}
