package tech.rowi.dbo.claimapi.dto.reference;

public enum ClaimTypesEnum {
    ERROR("ERROR", "Ошибка в системе"),
    NAVIGATION("NAVIGATION", "Навигация в системе ИС ROWI"),
    INQUIRY("INQUIRY", "Запрос справок и выписок"),
    DATA_UPDATE("DATA_UPDATE", "Обновление данных"),
    CONSULTATION("CONSULTATION", "Консультация"),
    CLOSE_ACCOUNT("CLOSE_ACCOUNT", "Закрытие счета"),
    CURRENCY_CONTROL("CURRENCY_CONTROL", "Валютный контроль"),
    CB_REQUEST("CB_REQUEST", "Запрос ЦБ"),
    NEW_SERVICE("NEW_SERVICE", "Новая услуга"),
    PROFILE_MANAGEMENT("PROFILE_MANAGEMENT", "Управление УЗ ИС РОВИ"),
    UNKNOWN("UNKNOWN", "Невыясненные"),
    EXTRA_ACCOUNT("EXTRA_ACCOUNT", "Открытие дополнительного счета"),
    TARIFF_CHANGE("TARIFF_CHANGE", "Смена тарифа"),
    NOMINAL_PAYMENT("NOMINAL_PAYMENT", "Создание п\\п с номинального счета"),
    CLAIM("CLAIM", "Претензия"),
    OTHER("OTHER", "Иное");

    private final String code;
    private final String text;

    ClaimTypesEnum(String code, String text) {
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
