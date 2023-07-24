package tech.rowi.dbo.claimapi.dto.request;

import lombok.Data;
import tech.rowi.dbo.claimapi.dto.reference.StatusesEnum;

@Data
public class ClaimCloseRequest {
    private StatusesEnum status;
    private String statusReason;
    private String comment;
}
