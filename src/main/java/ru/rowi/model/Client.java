package ru.rowi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clients_id_seq")
    @SequenceGenerator(name = "clients", sequenceName = "clients_id_seq", allocationSize = 1)
    private Long id;

    private Long globalCompanyId;
    private String inn;
    private String kpp;
    private String orgn;
    private String fullName;
    private String shortName;
}
