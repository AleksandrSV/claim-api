package ru.rowi.mapper;

import org.springframework.stereotype.Component;
import ru.rowi.dto.reference.StatusesEnum;
import ru.rowi.dto.request.ClaimPostRequest;
import ru.rowi.dto.request.ClientRequest;
import ru.rowi.dto.request.DocumentRequest;
import ru.rowi.model.Claim;
import ru.rowi.model.Client;
import ru.rowi.model.Document;

import java.time.LocalDateTime;

@Component
public class RequestMapper {
    public Claim postRequestToCreateClaim(ClaimPostRequest request, LocalDateTime localDateTime, String username) {
        Claim claim = new Claim();
        claim.setCategory(request.getCategory());
        claim.setCreatedDate(localDateTime);
        claim.setUpdatedDate(localDateTime);
        // ?
//        claim.setCreatedBy(username);
        claim.setUpdatedBy(username); // or from assignee
        if (request.getAssignee() != null)
            claim.setAssignee(request.getAssignee());
        else
            claim.setAssignee(username);

        // ?
        claim.setStatus(StatusesEnum.DRAFT);
        claim.setStatusReason(StatusesEnum.DRAFT.getCode());

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
        client.setInn(request.getInn());
        client.setKpp(request.getKpp());
        client.setOgrn(request.getOgrn());
        client.setFullName(request.getOgrn());
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
}
