package tech.rowi.dbo.claimapi.dto.reference;

public enum ClaimThemesEnum {
    IS_ROWI("IS_ROWI", "ИС РОВИ"),
    CHAT("CHAT", "Чат"),
    IBANK("IBANK", "iBank"),
    ACCOUNT_OPEN_INQUIRY("ACCOUNT_OPEN_INQUIRY", "Справка об открытии счета"),
    CASH_FLOW_INQUIRY("CASH_FLOW_INQUIRY", "Справка об оборотах"),
    ACCOUNT_CLOSE_INQUIRY("ACCOUNT_CLOSE_INQUIRY", "Справка о закрытии счета"),
    CARD_INDEX_INQUIRY("CARD_INDEX_INQUIRY", "Справка о картотеке"),
    LOAN_DEBT_INQUIRY("LOAN_DEBT_INQUIRY", "Справка о ссудной задолженности"),
    EXCERPT("EXCERPT", "Выписка"),
    VISIT_TO_CLIENT("VISIT_TO_CLIENT", "С выездом к Клиенту"),
    NO_VISIT_TO_CLIENT("NO_VISIT_TO_CLIENT", "Без выезда к Клиенту"),
    TARIFFS("TARIFFS", "Тарифы"),
    DOCUMENTS("DOCUMENTS", "Документы"),
    ACCOUNT_BLOCK("ACCOUNT_BLOCK", "Ограничения по счету"),
    PAYMENTS("PAYMENTS", "Платежи"),
    INTEREST_ON_BALANCE("INTEREST_ON_BALANCE", "Начисление % на остаток"),
    INITIATED_BY_CLIENT("INITIATED_BY_CLIENT", "По инициативе Клиента"),
    DOCUMENTS_REQUEST("DOCUMENTS_REQUEST", "Запрос документов"),
    BANK_SUPPORT_OF_CONTRACT("BANK_SUPPORT_OF_CONTRACT", "Банковское сопровождение контракта"),
    SUPPORT_OF_PREGIVEN_ACPT("SUPPORT_OF_PREGIVEN_ACPT", "Сопровождение заранее данного акцепта"),
    CREATE_NEW_PROFILE("CREATE_NEW_PROFILE", "Заведение новой УЗ"),
    BLOCK_PROFILE("BLOCK_PROFILE", "Блокировка УЗ"),
    UNBLOCK_PROFILE("UNBLOCK_PROFILE", "Разблокировка УЗ"),
    LEGAL_SUPPORT_REQUIRED("LEGAL_SUPPORT_REQUIRED", "Требуется юридическое сопровождение"),
    LEGAL_SUPPORT_NOT_REQUIRED("LEGAL_SUPPORT_NOT_REQUIRED", "Не требуется юридическое сопровождение"),
    OTHER("OTHER", "Иное");

    private final String code;
    private final String text;

    ClaimThemesEnum(String code, String text) {
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
