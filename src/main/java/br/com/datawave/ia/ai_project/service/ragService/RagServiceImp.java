package br.com.datawave.ia.ai_project.service.ragService;

import br.com.datawave.ia.ai_project.Infra.Security.AuthenticateFacade;
import br.com.datawave.ia.ai_project.domain.answer.UserAnswer;
import br.com.datawave.ia.ai_project.domain.data.InputDataContent;
import br.com.datawave.ia.ai_project.domain.data.MessageDto;
import br.com.datawave.ia.ai_project.domain.data.DataContent;
import br.com.datawave.ia.ai_project.factory.AiAssistentFactory;
import br.com.datawave.ia.ai_project.factory.ContentRetrieverFactory;
import br.com.datawave.ia.ai_project.factory.DocumentAssistantFactory;
import br.com.datawave.ia.ai_project.factory.EmbeddingFactory;
import br.com.datawave.ia.ai_project.repository.AnswerRepository;
import br.com.datawave.ia.ai_project.repository.DataRepository;
import br.com.datawave.ia.ai_project.service.answerService.AnswerService;
import dev.langchain4j.model.chat.ChatLanguageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class RagServiceImp implements RagService{

    @Autowired
    private DataRepository dataRepository;

    @Override
    public String getDataContent(MessageDto dto) {
        var response = getResponse(dto);
        return response;
    }

    @Override
    public void inputDataContent(InputDataContent input) {
        dataRepository.save(new DataContent(input.content()));
    }

    private String getResponse(MessageDto dto) {
        var chatModel = AiAssistentFactory.createLocalChatModel();
        var embeddingModel = EmbeddingFactory.createEmbeddingModel();
        var embeddingStore = EmbeddingFactory.createEmbeddingStore();

        var datas = dataRepository.findAll().stream().
                map(DataContent::getContent).collect(Collectors.joining("\n"));

        var fileContentRetriever = ContentRetrieverFactory.createStringContentRetriever(
                embeddingModel,
                embeddingStore,
                datas);

        var documentAssistant = new DocumentAssistantFactory(chatModel, fileContentRetriever);

        var response = documentAssistant.chat(dto.message());

        return response;
    }
}