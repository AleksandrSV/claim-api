package ru.rowi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long globalCompanyId;
    private String inn;
    private String kpp;
    private String orgn;
    private String fullName;
    private String shortName;
}
