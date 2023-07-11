package ru.rowi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.rowi.dto.ClaimSpecifications;
import ru.rowi.dto.request.ClaimFilterRequest;
import ru.rowi.dto.request.ClaimPostRequest;
import ru.rowi.dto.request.DocumentRequest;
import ru.rowi.mapper.RequestMapper;
import ru.rowi.model.Claim;
import ru.rowi.model.Client;
import ru.rowi.model.Document;
import ru.rowi.repository.ClaimRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClaimService {
    @Autowired
    private ClaimRepository repo;

    @Autowired
    private ClientService clientService;
    @Autowired
    private DocumentService documentService;

    // 2
    public Page<Claim> getClaimsByFilters(ClaimFilterRequest request) {
        int pageNum = 0;
        int pageSize = 10;
        if (request.getPageNum() != null) {
            pageNum = request.getPageNum();
        }
        if (request.getPageSize() != null) {
            pageSize = request.getPageSize();
        }
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Specification<Claim> specification = ClaimSpecifications.findByFilters(request);
        return repo.findAll(specification, pageable);
    }

    // 3
    public Optional<Claim> getClaimById(Long id) {
        return repo.findById(id);
    }

    // 4
    public ResponseEntity<?> createClaim(ClaimPostRequest request, LocalDateTime localDateTime, String username) {
        if (request.getCategory() == null) return ResponseEntity.badRequest().body("Does not exist:  category");
        Claim claim = RequestMapper.postRequestToCreateClaim(request, localDateTime, username);
        claim.setCreatedBy(username); // or from assignee

        if (request.getClient() != null) {
            Client client = RequestMapper.postRequestToClient(request.getClient());
            client = clientService.save(client);
            claim.setClientId(client);
        }

        claim = repo.save(claim);

        if (request.getDocuments() != null) {
            DocumentRequest[] docReq = request.getDocuments();
            Document tmp;
            List<Document> documents = new ArrayList<>();
            for (int i =0; i<docReq.length; i++) {
                tmp = RequestMapper.postRequestToDocument(docReq[i]);
                tmp.setClaimId(claim);
            }
            documentService.saveAll(documents);
        }


        return ResponseEntity.ok(claim.getId());
    }


}
