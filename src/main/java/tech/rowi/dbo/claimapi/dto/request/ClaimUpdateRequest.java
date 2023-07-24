package tech.rowi.dbo.claimapi.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import tech.rowi.dbo.claimapi.dto.reference.PriorityEnum;

@Data
public class ClaimUpdateRequest {
    private PriorityEnum priority;
    @JsonProperty("priority_reason")
    private String priorityReason;
    private String assignee;
    private String comment;
    private DocumentRequest[] documents;
}
