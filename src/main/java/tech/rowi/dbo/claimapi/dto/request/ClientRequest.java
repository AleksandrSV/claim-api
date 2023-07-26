package tech.rowi.dbo.claimapi.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Data
public class ClientRequest {
    @Positive
    private Long globalCompanyId;
//    @Pattern(
//            regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$",
//            message = "Не соответствует формату UUID")
    private UUID plCompanyId;
    @NotNull
    @Pattern(
            regexp = "^(([0-9]{12})|([0-9]{10}))?$",
            message = "Не соответствует формату ИНН")
    private String inn;
    @Pattern(
            regexp = "^([0-9]{9})?$",
            message = "Не соответствует формату КПП")
    private String kpp;
    @NotNull
    @Pattern(
            regexp = "^([0-9]{13})?$",
            message = "Не соответствует формату ОГРН")
    private String ogrn;
    @NotNull
    private String fullName;
    @NotNull
    private String shortName;
}
