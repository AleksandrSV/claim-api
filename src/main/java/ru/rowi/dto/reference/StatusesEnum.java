package ru.rowi.dto.reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum StatusesEnum {
    DRAFT("DRAFT", "Черновик"),
    NEW("NEW", "Новое"),
    PENDING("PENDING", "В ожидании"),
    IN_PROGRESS("IN_PROGRESS", "В процессе"),
    DONE("DONE", "Выполнено",
            new ArrayList<>(Arrays.asList(
                    new ReferenceItem("DONE", "Закрыто"),
                    new ReferenceItem("FORWARDED", "Переведено в другое подразделение")
            ))),
    REJECTED("REJECTED", "Отклонено",
            new ArrayList<>(Arrays.asList(
                    new ReferenceItem("INITIATOR_REJECTED", "Отказ инициатора"),
                    new ReferenceItem("WRONG_CREATED", "Ошибочно заведено"),
                    new ReferenceItem("DUPLICATE", "Дубликат")
            )));

    private final String code;
    private final String text;
    private final List<ReferenceItem> reasons;

    StatusesEnum(String code, String text, ArrayList<ReferenceItem> reasons) {
        this.code = code;
        this.text = text;
        this.reasons = reasons;
    }

    StatusesEnum(String code, String text) {
        this(code, text, null);
    }

    public String getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public List<ReferenceItem> getReasons() {
        return reasons;
    }
}
