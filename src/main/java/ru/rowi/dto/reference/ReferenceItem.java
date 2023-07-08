package ru.rowi.dto.reference;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
public class ReferenceItem {
    private String code;
    private String text;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ReferenceItem> reasons;

    public ReferenceItem(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public ReferenceItem(String code, String text, List<ReferenceItem> reasons) {
        this.code = code;
        this.text = text;
        this.reasons = reasons;
    }
}
