package tech.rowi.dbo.claimapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long globalCompanyId;
    private UUID plCompanyId;
    private String inn;
    private String kpp;
    private String ogrn;
    private String fullName;
    private String shortName;
}
