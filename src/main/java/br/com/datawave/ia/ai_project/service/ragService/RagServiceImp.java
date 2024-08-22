package br.com.datawave.ia.ai_project.service.ragService;

import br.com.datawave.ia.ai_project.domain.data.InputDataContent;
import br.com.datawave.ia.ai_project.domain.data.MessageDto;
import br.com.datawave.ia.ai_project.domain.data.DataContent;
import br.com.datawave.ia.ai_project.factory.AiAssistentFactory;
import br.com.datawave.ia.ai_project.factory.ContentRetrieverFactory;
import br.com.datawave.ia.ai_project.factory.DocumentAssistantFactory;
import br.com.datawave.ia.ai_project.factory.EmbeddingFactory;
import br.com.datawave.ia.ai_project.repository.DataRepository;
import dev.langchain4j.model.chat.ChatLanguageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RagServiceImp implements RagService{

    @Autowired
    private DataRepository repository;

    @Override
    public String getDataContent(MessageDto dto) {
        ChatLanguageModel chatModel = AiAssistentFactory.createLocalChatModel();
        var embeddingModel = EmbeddingFactory.createEmbeddingModel();
        var embeddingStore = EmbeddingFactory.createEmbeddingStore();

        var data = repository.findAll().stream().map
                (DataContent::getContent).collect(Collectors.joining("\n"));

        var fileContentRetriever = ContentRetrieverFactory.createStringContentRetriever(
                embeddingModel,
                embeddingStore,
                data);

        var documentAssistant = new DocumentAssistantFactory(chatModel, fileContentRetriever);
        return documentAssistant.chat(dto.message());
    }

    @Override
    public void inputDataContent(InputDataContent input) {
        repository.save(new DataContent(input.content()));
    }
}
