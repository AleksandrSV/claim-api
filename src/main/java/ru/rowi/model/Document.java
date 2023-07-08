package ru.rowi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "documents")
public class Document {
    @Id
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "size")
    private Long size;

    @ManyToOne
    @JoinColumn(name = "claim_id")
    private Claim claimId;

}
