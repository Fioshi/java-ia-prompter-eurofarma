package br.com.datawave.ia.ai_project.factory;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.DocumentParser;
import dev.langchain4j.data.document.DocumentSplitter;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.parser.TextDocumentParser;
import dev.langchain4j.data.document.splitter.DocumentSplitters;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.store.embedding.EmbeddingStore;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ContentRetrieverFactory {

    public static ContentRetriever createStringContentRetriever(
            EmbeddingModel embeddingModel, EmbeddingStore<TextSegment> embeddingStore, String content) {
        var segments = createTextSegments(content);

        var embeddings = embeddingModel.embedAll(segments).content();

        embeddingStore.addAll(embeddings, segments);

        return EmbeddingStoreContentRetriever.builder()
                .embeddingStore(embeddingStore)
                .embeddingModel(embeddingModel)
                .maxResults(5)
                .minScore(0.5)
                .build();
    }

    private static List<TextSegment> createTextSegments(String content) {
        DocumentParser documentParser = new TextDocumentParser();
        InputStream inputStream = new ByteArrayInputStream(content.getBytes());
        Document document = documentParser.parse(inputStream);
        DocumentSplitter splitter = DocumentSplitters.recursive(content.length(), 50);
        return splitter.split(document);
    }
}
