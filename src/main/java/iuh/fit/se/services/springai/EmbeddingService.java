package iuh.fit.se.services.springai;

import iuh.fit.se.dtos.request.EmbeddingRequest;
import iuh.fit.se.entities.Product;
import org.springframework.ai.document.Document;

import java.util.List;

public interface EmbeddingService {
    void createEmbedding(EmbeddingRequest product);
    List<Document> search(String query);
}
