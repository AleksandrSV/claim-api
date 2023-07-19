package tech.rowi.dbo.claimapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import tech.rowi.dbo.claimapi.dto.ClaimSpecifications;
import tech.rowi.dbo.claimapi.dto.request.ClaimFilterRequest;
import tech.rowi.dbo.claimapi.dto.request.ClaimPostRequest;
import tech.rowi.dbo.claimapi.dto.request.DocumentRequest;
import tech.rowi.dbo.claimapi.mapper.RequestMapper;
import tech.rowi.dbo.claimapi.model.Claim;
import tech.rowi.dbo.claimapi.model.Client;
import tech.rowi.dbo.claimapi.model.Document;
import tech.rowi.dbo.claimapi.repository.ClaimRepository;
import tech.rowi.dbo.claimapi.util.TokenUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClaimService {

    private final RequestMapper mapper;
    private final ClaimRepository repo;
    private final ClientService clientService;
    private final TokenUtil tokenUtil;
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
    public Long createClaim(ClaimPostRequest request, LocalDateTime localDateTime) {
        if (request.getCategory() == null) throw new IllegalArgumentException("Does not exist:  category");

        String username = tokenUtil.getUsername();
        Claim claim = mapper.postRequestToCreateClaim(request, localDateTime, username);
        // Should be filled by Auditable
        // claim.setCreatedBy(username); // or from assignee

        if (request.getClient() != null) {
            Client client = mapper.postRequestToClient(request.getClient());
            client = clientService.save(client);
            claim.setClient(client);
        }

        claim = repo.save(claim);

        if (request.getDocuments() != null) {
            DocumentRequest[] docReq = request.getDocuments();
            Document tmp;
            List<Document> documents = new ArrayList<>();
            for (int i =0; i<docReq.length; i++) {
                tmp = mapper.postRequestToDocument(docReq[i]);
                tmp.setClaimId(claim);
            }
            documentService.saveAll(documents);
        }


        return claim.getId();
    }


}
