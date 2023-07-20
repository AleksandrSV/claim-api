package tech.rowi.dbo.claimapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import tech.rowi.dbo.claimapi.dto.ClaimSpecifications;
import tech.rowi.dbo.claimapi.dto.reference.StatusesEnum;
import tech.rowi.dbo.claimapi.dto.request.ClaimFilterRequest;
import tech.rowi.dbo.claimapi.dto.request.ClaimPostRequest;
import tech.rowi.dbo.claimapi.dto.request.ClaimUpdateRequest;
import tech.rowi.dbo.claimapi.dto.request.DocumentRequest;
import tech.rowi.dbo.claimapi.mapper.RequestMapper;
import tech.rowi.dbo.claimapi.model.Claim;
import tech.rowi.dbo.claimapi.model.Client;
import tech.rowi.dbo.claimapi.model.Document;
import tech.rowi.dbo.claimapi.repository.ClaimRepository;
import tech.rowi.dbo.claimapi.util.TokenUtil;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClaimService {

    private final RequestMapper mapper;
    private final ClaimRepository repo;
    private final ClientService clientService;
    private final TokenUtil tokenUtil;
    private final DocumentService documentService;

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
    public Long createClaim(ClaimPostRequest request) {
        Claim claim = mapper.postRequestToCreateClaim(request);
        claim.setStatus(StatusesEnum.NEW);
        claim.setStatusReason(StatusesEnum.NEW.getCode());

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
            for (int i = 0; i < docReq.length; i++) {
                tmp = mapper.postRequestToDocument(docReq[i]);
                tmp.setClaim(claim);
                documents.add(tmp);
            }
            documentService.saveAll(documents);
        }


        return claim.getId();
    }

    //5
    public Long updateClaim(ClaimUpdateRequest claimUpdateRequest, Long id) throws FileNotFoundException {
        Claim claim = repo.findById(id).orElseThrow(()-> new FileNotFoundException("File not found"));
        if (!claim.getAssignee().equals(tokenUtil.getUsername())) throw new IllegalArgumentException("Assignee != Username from token");

        claim.setPriority(claimUpdateRequest.getPriority());
        claim.setPriorityReason(claimUpdateRequest.getPriorityReason());
        claim.setAssignee(claimUpdateRequest.getAssignee());
        claim.setComment(claimUpdateRequest.getComment());

        List<DocumentRequest> documentRequests = Arrays.asList(claimUpdateRequest.getDocuments());
        List<Document> documents = new ArrayList<>();

        for(DocumentRequest docReq: documentRequests){
            documents.add(mapper.updateRequestToDocument(docReq, claim));
        }

        repo.save(claim);
        documentService.saveAll(documents);

        return claim.getId();
    }

}
