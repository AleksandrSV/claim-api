package tech.rowi.dbo.claimapi.model;

import lombok.Getter;
import lombok.Setter;
import tech.rowi.dbo.claimapi.dto.reference.PriorityEnum;
import tech.rowi.dbo.claimapi.dto.reference.StatusesEnum;

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
    @Enumerated(EnumType.STRING)
    private PriorityEnum priority;
    private String priorityReason;
    @Enumerated(EnumType.STRING)
    private StatusesEnum status;
    private String statusReason;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "claim_id")
    private Claim claim;


}
