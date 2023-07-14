package ru.rowi.dto.request;

import lombok.Data;
import ru.rowi.dto.reference.CategoriesEnum;
import ru.rowi.dto.reference.ChannelsEnum;
import ru.rowi.dto.reference.InitiatorTypeEnum;
import ru.rowi.dto.reference.PriorityEnum;

@Data
public class ClaimPostRequest {
    private CategoriesEnum category;
    private ChannelsEnum channel;
    private InitiatorTypeEnum initiatorType;
    private Boolean isFirstLine;
    // in progress
    private String claimType;
    //in progress
    private String ClaimTheme;
    private String description;
    private String comment;
    private Integer serviceCount;
    private PriorityEnum priority;
    private String priorityReason;
    // null ? username from Keycloak
    private String assignee;

    private ClientRequest client;
    private DocumentRequest[] documents;
}

