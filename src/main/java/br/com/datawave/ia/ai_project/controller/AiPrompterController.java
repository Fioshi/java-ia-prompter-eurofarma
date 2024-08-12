package br.com.datawave.ia.ai_project.controller;

import br.com.datawave.ia.ai_project.factory.AiAssistentFactory;
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

    @PostMapping
    public ResponseEntity<String> sendResponse(@RequestBody MessageDto dto){
        System.out.println(token);
        ChatLanguageModel chatLanguageModel = AiAssistentFactory.createHuggingFace(token);
        var response = chatLanguageModel.generate(dto.message());
        return ResponseEntity.ok().body(response);
    };
}
