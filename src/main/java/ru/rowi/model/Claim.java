package ru.rowi.model;

import lombok.Getter;
import lombok.Setter;
import ru.rowi.dto.State;

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
    private State status;
    private String statusReason;
    private LocalDateTime pauseTill;
    private String category;
    private String channel;
    private String initiatorType;
    private Boolean isFirstLine;
    private String claimType;
    private String claimTheme;
    private Integer serviceCount;
    private String priority;
    private String priorityReason;
    private String description;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client clientId;

}
