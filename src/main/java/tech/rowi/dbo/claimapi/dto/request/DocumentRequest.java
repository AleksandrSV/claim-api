package tech.rowi.dbo.claimapi.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class DocumentRequest {
    private UUID id;
    private String name;
    private Long size;
}
