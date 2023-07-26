package tech.rowi.dbo.claimapi.dto.request;

import lombok.Data;
import tech.rowi.dbo.claimapi.dto.reference.DivisionsEnum;

import javax.validation.constraints.NotNull;

@Data
public class ClaimForwardRequest {
    @NotNull
    private DivisionsEnum assignee;
    private String comment;
}
