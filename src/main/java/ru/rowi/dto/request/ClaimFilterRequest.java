package ru.rowi.dto.request;


import lombok.Data;
import ru.rowi.dto.reference.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
    // in progress
    private String claimType;
    // in progress
    private String claimTheme;

    @Enumerated(EnumType.STRING)
    private PriorityEnum priority;

    @Enumerated(EnumType.STRING)
    private StatusesEnum status;
    private String assignee;

    // client
    private Long globalCompanyId;
    private String clientInn;
    private String clientKpp;
    private String clientOgrn;
}
