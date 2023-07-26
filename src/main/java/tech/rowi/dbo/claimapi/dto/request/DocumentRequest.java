package tech.rowi.dbo.claimapi.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Data
public class DocumentRequest {
    @NotNull
    private UUID id;
    @NotNull
    private String name;
    @Positive
    @NotNull
    private Long size;
}
