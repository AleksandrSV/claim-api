package ru.rowi.dto.reference;

public enum ChannelsEnum {
    CHAT("CHAT", "Чат"),
    PHONE("PHONE", "Телефон"),
    EMAIL("EMAIL", "E-mail");

    private final String code;
    private final String text;

    ChannelsEnum(String code, String text) {
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
