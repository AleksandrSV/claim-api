package tech.rowi.dbo.claimapi.dto.request;

import lombok.Data;
import tech.rowi.dbo.claimapi.dto.reference.DivisionsEnum;

@Data
public class ClaimForwardRequest {
    private DivisionsEnum assignee;
    private String comment;
}
