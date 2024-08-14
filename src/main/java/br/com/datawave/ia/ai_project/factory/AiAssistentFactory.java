package br.com.datawave.ia.ai_project.factory;

import com.mysql.cj.jdbc.MysqlDataSource;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.huggingface.HuggingFaceChatModel;

import javax.sql.DataSource;
import java.time.Duration;

public class AiAssistentFactory {

    public static ChatLanguageModel  createHuggingFace(String token){
        return HuggingFaceChatModel.builder()
                .accessToken(token)
                .modelId("TheBloke/Wizard-Vicuna-13B-Uncensored-GGUF")
                .timeout(Duration.ofSeconds(300))
                .build();
    }

}
