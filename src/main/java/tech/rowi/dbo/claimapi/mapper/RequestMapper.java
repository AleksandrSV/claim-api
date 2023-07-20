package tech.rowi.dbo.claimapi.mapper;

import org.springframework.stereotype.Component;
import tech.rowi.dbo.claimapi.dto.reference.StatusesEnum;
import tech.rowi.dbo.claimapi.dto.request.ClaimPostRequest;
import tech.rowi.dbo.claimapi.dto.request.ClientRequest;
import tech.rowi.dbo.claimapi.dto.request.DocumentRequest;
import tech.rowi.dbo.claimapi.model.Claim;
import tech.rowi.dbo.claimapi.model.Client;
import tech.rowi.dbo.claimapi.model.Document;


@Component
public class RequestMapper {
    public Claim postRequestToCreateClaim(ClaimPostRequest request) {
        Claim claim = new Claim();
        claim.setCategory(request.getCategory());
        claim.setAssignee(request.getAssignee());
        claim.setChannel(request.getChannel());
        claim.setInitiatorType(request.getInitiatorType());
        claim.setIsFirstLine(request.getIsFirstLine());
        claim.setClaimType(request.getClaimType());
        claim.setClaimTheme(request.getClaimTheme());
        claim.setServiceCount(request.getServiceCount());
        claim.setPriority(request.getPriority());
        claim.setPriorityReason(request.getPriorityReason());
        claim.setDescription(request.getDescription());
        claim.setComment(request.getComment());
        return claim;
    }

    public Client postRequestToClient(ClientRequest request) {
        Client client = new Client();
        client.setGlobalCompanyId(request.getGlobalCompanyId());
        client.setPlCompanyId(request.getPlCompanyId());
        client.setInn(request.getInn());
        client.setKpp(request.getKpp());
        client.setOgrn(request.getOgrn());
        client.setFullName(request.getFullName());
        client.setShortName(request.getShortName());
        return client;
    }

    public Document postRequestToDocument(DocumentRequest request) {
        Document doc = new Document();
        doc.setId(request.getId());
        doc.setName(request.getName());
        doc.setSize(request.getSize());
        return doc;
    }

    public Document updateRequestToDocument(DocumentRequest request, Claim claim){
        Document doc = new Document();
        doc.setId(request.getId());
        doc.setName(request.getName());
        doc.setSize(request.getSize());
        doc.setClaim(claim);
        return doc;
    }
}
