package ru.rowi.dto.reference;

public enum DivisionsEnum {
    SELLPLUS("SELLPLUS", "Sellplus"),
    KIK("KIK", "КИК"),
    GUARANTEE("GUARANTEE", "ЦБГ"),
    FACTORING("FACTORING", "Факторинг");

    private final String code;
    private final String text;

    DivisionsEnum(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public String getText() {
        return text;
    }
}
