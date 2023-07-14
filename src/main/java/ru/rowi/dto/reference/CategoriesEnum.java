package ru.rowi.dto.reference;

public enum CategoriesEnum {
    INCOMING("INCOMING", "Входящее"),
    OUTGOING("OUTGOING", "Исходящее");

    private final String code;
    private final String text;

    CategoriesEnum(String code, String text) {
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
