package ru.rowi.model;

import lombok.Data;
import ru.rowi.dto.State;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "claims")
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "claims_id_seq")
    @SequenceGenerator(name = "claims", sequenceName = "claims_id_seq", allocationSize = 1)
    private Long id;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private String createdBy;
    private String updatedBy;
    private String assignee;

    @Enumerated(EnumType.STRING)
    private State status;
    private String statusReason;
    private Timestamp pauseTill;
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
