package tech.rowi.dbo.claimapi.mapper;

import org.springframework.stereotype.Component;
import tech.rowi.dbo.claimapi.dto.request.ClaimPostRequest;
import tech.rowi.dbo.claimapi.dto.request.ClientRequest;
import tech.rowi.dbo.claimapi.dto.request.DocumentRequest;
import tech.rowi.dbo.claimapi.model.Claim;
import tech.rowi.dbo.claimapi.model.Client;
import tech.rowi.dbo.claimapi.model.Document;


@Component
public class RequestMapper {
    public Claim requestToClaim(ClaimPostRequest request) {
        return requestToClaim(request, new Claim());
    }

    public Claim requestToClaim(ClaimPostRequest request, Claim claim) {
        claim.setCategory(request.getCategory());
        claim.setChannel(request.getChannel());
        claim.setInitiatorType(request.getInitiatorType());
        claim.setIsFirstLine(request.getIsFirstLine());
        claim.setClaimType(request.getClaimType());
        claim.setClaimTheme(request.getClaimTheme());
        claim.setDescription(request.getDescription());
        claim.setComment(request.getComment());
        claim.setServiceCount(request.getServiceCount());
        claim.setPriority(request.getPriority());
        claim.setPriorityReason(request.getPriorityReason());
        claim.setAssignee(request.getAssignee());
        return claim;
    }

    public Client requestToClient(ClientRequest request) {
        return requestToClient(request, new Client());
    }

    public Client requestToClient(ClientRequest request, Client client) {
        client.setGlobalCompanyId(request.getGlobalCompanyId());
        client.setPlCompanyId(request.getPlCompanyId());
        client.setInn(request.getInn());
        client.setKpp(request.getKpp());
        client.setOgrn(request.getOgrn());
        client.setFullName(request.getFullName());
        client.setShortName(request.getShortName());
        return client;
    }

    public Document requestToDocument(DocumentRequest request) {
        Document doc = new Document();
        doc.setId(request.getId());
        doc.setName(request.getName());
        doc.setSize(request.getSize());
        return doc;
    }

    public Document requestToDocument(DocumentRequest request, Claim claim){
        Document doc = requestToDocument(request);
        doc.setClaim(claim);
        return doc;
    }
}
