package ru.rowi.dto.reference;

public enum ReferenceEnum {
    INCOMING("INCOMING", "Входящее"),
    OUTGOING("OUTGOING", "Исходящее"),
    CHAT("CHAT", "Чат"),
    PHONE("PHONE", "Телефон"),
    EMAIL("EMAIL", "E-mail"),
    CLIENT("CLIENT", "Клиент"),
    NOT_CLIENT("NOT_CLIENT", "Не Клиент"),
    PRODUCT("PRODUCT", "Основной продукт"),
    DELIVERY("DELIVERY", "Доставка"),
    OTHER("OTHER", "Иное"),
    SELLPLUS("SELLPLUS", "Sellplus"),
    KIK("KIK", "КИК"),
    GUARANTEE("GUARANTEE", "ЦБГ"),
    FACTORING("FACTORING", "Факторинг"),
    CRITICAL("CRITICAL", "Критический"),
    HIGH("HIGH", "Высокий"),
    MEDIUM("MEDIUM", "Средний"),
    LOW("LOW", "Низкий"),
    PAUSE("PAUSE", "Приостановлено"),
    DRAFT("DRAFT", "Черновик"),
    NEW("NEW", "Новое"),
    PENDING("PENDING", "В ожидании"),
    IN_PROGRESS("IN_PROGRESS", "В процессе"),
    DONE("DONE", "Выполнено"),
    FORWARDED("FORWARDED", "Переведено в другое подразделение"),
    REJECTED("REJECTED", "Отклонено"),
    INITIATOR_REJECTED("INITIATOR_REJECTED", "Отказ инициатора"),
    WRONG_CREATED("WRONG_CREATED", "Ошибочно заведено"),
    DUPLICATE("DUPLICATE", "Дубликат");

    private final String code;
    private final String text;

    ReferenceEnum(String code, String text) {
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
