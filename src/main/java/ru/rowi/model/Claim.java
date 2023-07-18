package ru.rowi.model;

import lombok.Getter;
import lombok.Setter;
import ru.rowi.dto.reference.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "claims")
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String createdBy;
    private String updatedBy;
    private String assignee;

    @Enumerated(EnumType.STRING)
    private StatusesEnum status;
    private String statusReason;
    private LocalDateTime pauseTill;

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
    private Integer serviceCount;

    @Enumerated(EnumType.STRING)
    private PriorityEnum priority;
    private String priorityReason;
    private String description;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client clientId;

}
