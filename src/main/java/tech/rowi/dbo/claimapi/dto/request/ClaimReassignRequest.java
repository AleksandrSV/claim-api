package tech.rowi.dbo.claimapi.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ClaimReassignRequest {
    @NotNull
    private String assignee;
}
