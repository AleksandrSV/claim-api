package tech.rowi.dbo.claimapi.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Data
public class DocumentRequest {
//    @Pattern(
//            regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$",
//            message = "Не соответствует формату UUID")
    @NotNull
    private UUID id;
    @NotNull
    private String name;
    @Positive
    @NotNull
    private Long size;
}
