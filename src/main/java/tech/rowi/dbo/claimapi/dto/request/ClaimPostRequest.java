package tech.rowi.dbo.claimapi.dto.request;

import lombok.Data;
import tech.rowi.dbo.claimapi.dto.reference.*;

@Data
public class ClaimPostRequest {
    private CategoriesEnum category;
    private ChannelsEnum channel;
    private InitiatorTypeEnum initiatorType;
    private Boolean isFirstLine;
    private ClaimTypesEnum claimType;
    private ClaimThemesEnum ClaimTheme;
    private String description;
    private String comment;
    private Integer serviceCount;
    private PriorityEnum priority;
    private String priorityReason;
    private String assignee;

    private ClientRequest client;
    private DocumentRequest[] documents;
}

