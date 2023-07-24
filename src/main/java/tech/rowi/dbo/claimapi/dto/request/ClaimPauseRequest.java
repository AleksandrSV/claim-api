package tech.rowi.dbo.claimapi.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ClaimPauseRequest {
    @JsonProperty("pause_till")
    private LocalDateTime pauseTill;
    private String comment;
}
