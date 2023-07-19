package tech.rowi.dbo.claimapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "documents")
public class Document {
    @Id
    private UUID id;
    private String name;
    private Long size;
    @ManyToOne
    @JoinColumn(name = "claim_id")
    private Claim claim;

}
