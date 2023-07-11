package ru.rowi.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.rowi.dto.reference.CategoriesRefEnum;
import ru.rowi.dto.reference.ChannelsRefEnum;
import ru.rowi.dto.reference.InitiatorTypeRefEnum;
import ru.rowi.dto.reference.PriorityRefEnum;

import java.util.UUID;

@Data
public class ClaimPostRequest {
    private CategoriesRefEnum category;
    private ChannelsRefEnum channel;
    private InitiatorTypeRefEnum initiatorType;
    private Boolean isFirstLine;
    // in progress
    private String claimType;
    //in progress
    private String ClaimTheme;
    private String description;
    private String comment;
    private Integer serviceCount;
    private PriorityRefEnum priority;
    private String priorityReason;
    // null ? username from Keycloak
    private String assignee;

    private ClientRequest client;
    private DocumentRequest[] documents;
}

