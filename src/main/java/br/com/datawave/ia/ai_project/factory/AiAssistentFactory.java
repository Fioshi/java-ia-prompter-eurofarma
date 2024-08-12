package br.com.datawave.ia.ai_project.factory;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.huggingface.HuggingFaceChatModel;

import java.time.Duration;

public class AiAssistentFactory {

    public static ChatLanguageModel  createHuggingFace(String token){
        return HuggingFaceChatModel.builder()
                .accessToken(token)
                .modelId("google/gemma-2-2b-it")
                .timeout(Duration.ofSeconds(300))
                .build();
    }

}
