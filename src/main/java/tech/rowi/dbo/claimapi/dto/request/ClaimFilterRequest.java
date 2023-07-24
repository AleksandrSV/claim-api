package tech.rowi.dbo.claimapi.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import tech.rowi.dbo.claimapi.dto.reference.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Data
public class ClaimFilterRequest {
    private Integer pageNum;
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
    private String clientInn;
    private String clientKpp;
    private String clientOgrn;
}
