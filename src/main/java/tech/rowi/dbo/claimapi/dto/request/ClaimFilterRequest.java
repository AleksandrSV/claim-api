package tech.rowi.dbo.claimapi.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import tech.rowi.dbo.claimapi.dto.reference.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Data
public class ClaimFilterRequest {
    @Positive
    private Integer pageNum;
    @Positive
    private Integer pageSize;

    @Enumerated(EnumType.STRING)
    private CategoriesEnum category;

    @Enumerated(EnumType.STRING)
    private ChannelsEnum channel;

    @Enumerated(EnumType.STRING)
    private InitiatorTypeEnum initiatorType;

    private Boolean isFirstLine;
    @Enumerated(EnumType.STRING)
    private ClaimTypesEnum claimType;
    @Enumerated(EnumType.STRING)
    private ClaimThemesEnum claimTheme;

    @Enumerated(EnumType.STRING)
    private PriorityEnum priority;

    @Enumerated(EnumType.STRING)
    private StatusesEnum status;
    private String assignee;

    @JsonProperty("pause_till_from")
    private LocalDateTime pauseTillFrom;
    @JsonProperty("pause_till_till")
    private LocalDateTime pauseTillTill;

    // client
    @Pattern(
            regexp = "^(([0-9]{12})|([0-9]{10}))?$",
            message = "Не соответствует формату ИНН")
    private String clientInn;
    @Pattern(
            regexp = "^([0-9]{9})?$",
            message = "Не соответствует формату КПП")
    private String clientKpp;
    @Pattern(
            regexp = "^([0-9]{13})?$",
            message = "Не соответствует формату ОГРН")
    private String clientOgrn;
}
