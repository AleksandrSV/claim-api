package tech.rowi.dbo.claimapi.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import tech.rowi.dbo.claimapi.dto.reference.PriorityEnum;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class ClaimUpdateRequest {
    @NotNull
    private PriorityEnum priority;
    @JsonProperty("priority_reason")
    private String priorityReason;
    private String assignee;
    private String comment;
    @Valid
    private DocumentRequest[] documents;
}
