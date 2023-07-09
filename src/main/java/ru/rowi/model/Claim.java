package ru.rowi.model;

import lombok.Getter;
import lombok.Setter;
import ru.rowi.dto.State;
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
    private StatusesRefEnum status;
    private String statusReason;
    private LocalDateTime pauseTill;

    @Enumerated(EnumType.STRING)
    private CategoriesRefEnum category;

    @Enumerated(EnumType.STRING)
    private ChannelsRefEnum channel;

    @Enumerated(EnumType.STRING)
    private InitiatorTypeRefEnum initiatorType;
    private Boolean isFirstLine;
    // in progress
    private String claimType;
    // in progress
    private String claimTheme;
    private Integer serviceCount;

    @Enumerated(EnumType.STRING)
    private PriorityRefEnum priority;
    private String priorityReason;
    private String description;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client clientId;

}
