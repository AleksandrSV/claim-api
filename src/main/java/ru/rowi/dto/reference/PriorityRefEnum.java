package ru.rowi.dto.reference;

public enum PriorityRefEnum {
    CRITICAL("CRITICAL", "Критический"),
    HIGH("HIGH", "Высокий"),
    MEDIUM("MEDIUM", "Средний"),
    LOW("LOW", "Низкий"),
    PAUSE("PAUSE", "Приостановлено");

    private final String code;
    private final String text;

    PriorityRefEnum(String code, String text) {
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
