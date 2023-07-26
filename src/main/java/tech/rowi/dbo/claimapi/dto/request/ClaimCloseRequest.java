package tech.rowi.dbo.claimapi.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import tech.rowi.dbo.claimapi.dto.reference.StatusesEnum;

import javax.validation.constraints.NotNull;

@Data
public class ClaimCloseRequest {
    @NotNull
    private StatusesEnum status;
    @JsonProperty("status_reason")
    private String statusReason;
    private String comment;
}
