package tech.rowi.dbo.claimapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.rowi.dbo.claimapi.dto.request.DocumentRequest;
import tech.rowi.dbo.claimapi.mapper.RequestMapper;
import tech.rowi.dbo.claimapi.model.Claim;
import tech.rowi.dbo.claimapi.model.Document;
import tech.rowi.dbo.claimapi.repository.DocumentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService {
    private final RequestMapper mapper;
    private final DocumentRepository repo;

    public List<Document> saveAllFromRequest(DocumentRequest[] docs, Claim claim) {
        Document tmp;
        List<Document> documents = new ArrayList<>();
        for (DocumentRequest docReq : docs) {
            tmp = mapper.requestToDocument(docReq);
            tmp.setClaim(claim);
            documents.add(tmp);
        }
        return repo.saveAll(documents);
    }

    public Document save(Document document) {
        return repo.save(document);
    }

    public List<Document> saveAll(List<Document> docs) {
        return repo.saveAll(docs);
    }
}
