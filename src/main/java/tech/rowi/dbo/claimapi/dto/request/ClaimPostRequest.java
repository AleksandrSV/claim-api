package tech.rowi.dbo.claimapi.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import tech.rowi.dbo.claimapi.dto.reference.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class ClaimPostRequest {
    @NotNull
    private CategoriesEnum category;
    private ChannelsEnum channel;
    private InitiatorTypeEnum initiatorType;
    private Boolean isFirstLine;
    private ClaimTypesEnum claimType;
    private ClaimThemesEnum ClaimTheme;
    private String description;
    private String comment;
    @Positive
    private Integer serviceCount;
    private PriorityEnum priority;
    @JsonProperty("priority_reason")
    private String priorityReason;
    private String assignee;

    @Valid
    private ClientRequest client;
    @Valid
    private DocumentRequest[] documents;
}

