package tech.rowi.dbo.claimapi.dto.reference;

public enum InitiatorTypeEnum {
    CLIENT("CLIENT", "Клиент"),
    NOT_CLIENT("NOT_CLIENT", "Не Клиент"),
    PRODUCT("PRODUCT", "Основной продукт"),
    DELIVERY("DELIVERY", "Доставка"),
    OTHER("OTHER", "Иное");

    private final String code;
    private final String text;

    InitiatorTypeEnum(String code, String text) {
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
