package tech.rowi.dbo.claimapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.rowi.dbo.claimapi.model.Document;
import tech.rowi.dbo.claimapi.repository.DocumentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService {
    private final DocumentRepository repo;

    public Document save(Document document) {
        return repo.save(document);
    }

    public List<Document> saveAll(List<Document> docs) {
        return repo.saveAll(docs);
    }
}
