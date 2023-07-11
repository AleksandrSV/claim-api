package ru.rowi.dto.request;

import lombok.Data;

@Data
public class ClientRequest {
    private Long globalCompanyId;
    private String inn;
    private String kpp;
    private String ogrn;
    private String fullname;
    private String shortName;
}
