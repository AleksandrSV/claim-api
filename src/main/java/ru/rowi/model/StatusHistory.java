package ru.rowi.model;


import lombok.Data;
import ru.rowi.dto.State;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "status_history")
public class StatusHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "status_history_id_seq")
    @SequenceGenerator(name = "status_history", sequenceName = "status_history_id_seq", allocationSize = 1)
    private Long id;

    private Timestamp updatedDate;
    private String updatedBy;
    private String priority;
    private String priorityReason;
    @Enumerated(EnumType.STRING)
    private State status;
    private String statusReason;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "claim_id")
    private Claim claimId;







}
