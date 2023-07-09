package ru.rowi.model;

import lombok.Getter;
import lombok.Setter;
import ru.rowi.dto.State;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "status_history")
public class StatusHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime updatedDate;
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
