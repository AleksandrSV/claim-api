package tech.rowi.dbo.claimapi.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class ClientRequest {
    private Long globalCompanyId;
    private UUID plCompanyId;
    private String inn;
    private String kpp;
    private String ogrn;
    private String fullName;
    private String shortName;
}
