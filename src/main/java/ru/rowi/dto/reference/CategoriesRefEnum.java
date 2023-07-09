package ru.rowi.dto.reference;

public enum CategoriesRefEnum {
    INCOMING("INCOMING", "Входящее"),
    OUTGOING("OUTGOING", "Исходящее");

    private final String code;
    private final String text;

    CategoriesRefEnum(String code, String text) {
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
