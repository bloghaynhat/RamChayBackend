package iuh.fit.se.services.springai.impl;

import iuh.fit.se.dtos.request.EmbeddingRequest;
import iuh.fit.se.entities.Product;
import iuh.fit.se.services.springai.EmbeddingService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmbeddingServiceImpl implements EmbeddingService {
    private final EmbeddingModel embeddingModel;
    private final VectorStore vectorStore;

    @Override
    public void createEmbedding(EmbeddingRequest product) {
        Document doc = new Document(
                product.getId().toString(),
                product.getDescription(),
                Map.of("name", product.getName())
        );

        vectorStore.add(List.of(doc));
    }

    @Override
    public List<Document> search(String query) {
        return vectorStore.similaritySearch(query);
    }
}
