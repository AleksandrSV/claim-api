package tech.rowi.dbo.claimapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.rowi.dbo.claimapi.model.Document;
import tech.rowi.dbo.claimapi.repository.DocumentRepository;

import java.util.List;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository repo;

    public Document save(Document document) {
        return repo.save(document);
    }

    public List<Document> saveAll(List<Document> docs) {
        return repo.saveAll(docs);
    }
}
