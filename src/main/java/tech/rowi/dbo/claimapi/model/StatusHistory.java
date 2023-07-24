package tech.rowi.dbo.claimapi.model;

import lombok.Getter;
import lombok.Setter;
import tech.rowi.dbo.claimapi.dto.audit.AuditableStatusHistory;
import tech.rowi.dbo.claimapi.dto.reference.PriorityEnum;
import tech.rowi.dbo.claimapi.dto.reference.StatusesEnum;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "status_history")
public class StatusHistory extends AuditableStatusHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
