package tech.rowi.dbo.claimapi.dto.request;

import lombok.Data;
import tech.rowi.dbo.claimapi.dto.reference.PriorityEnum;

@Data
public class ClaimUpdateRequest {
    private PriorityEnum priority;
    private String priorityReason;
    // null ? username from Keycloak
    private String assignee;

    private String comment;
    private DocumentRequest[] documents;
}
