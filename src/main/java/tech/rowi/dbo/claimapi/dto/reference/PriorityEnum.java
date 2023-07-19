package tech.rowi.dbo.claimapi.dto.reference;

public enum PriorityEnum {
    CRITICAL("CRITICAL", "Критический"),
    HIGH("HIGH", "Высокий"),
    MEDIUM("MEDIUM", "Средний"),
    LOW("LOW", "Низкий"),
    PAUSE("PAUSE", "Приостановлено");

    private final String code;
    private final String text;

    PriorityEnum(String code, String text) {
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
