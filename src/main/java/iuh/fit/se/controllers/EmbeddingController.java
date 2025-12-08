package iuh.fit.se.controllers;

import iuh.fit.se.dtos.request.EmbeddingRequest;
import iuh.fit.se.entities.Product;
import iuh.fit.se.services.springai.EmbeddingService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.document.Document;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/embedding")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class EmbeddingController {
    private final EmbeddingService embeddingService;

    @PostMapping
    public String embedProduct(@RequestBody EmbeddingRequest product) {
        embeddingService.createEmbedding(product);

        return "ok";
    }

    @GetMapping("/search")
    public List<Document> search(@RequestParam String q) {
        return embeddingService.search(q);
    }
}
