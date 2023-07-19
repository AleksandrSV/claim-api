package tech.rowi.dbo.claimapi.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import tech.rowi.dbo.claimapi.dto.reference.ReferenceItem;
import tech.rowi.dbo.claimapi.dto.reference.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class ReferenceResponse {
    private List<ReferenceItem> categories;
    private List<ReferenceItem> channels;
    private List<ReferenceItem> initiatorTypes;
    private List<ReferenceItem> divisions;
    private List<ReferenceItem> priority;
    private List<ReferenceItem> statuses;
    private List<ReferenceItem> claimTypes;
    private List<ReferenceItem> claimThemes;

    ReferenceResponse (){
        this.categories = new ArrayList<>();
        categories.add(new ReferenceItem(CategoriesEnum.INCOMING.getCode(), CategoriesEnum.INCOMING.getText()));
        categories.add(new ReferenceItem(CategoriesEnum.OUTGOING.getCode(), CategoriesEnum.OUTGOING.getText()));

        // Channels
        this.channels = new ArrayList<>();
        channels.add(new ReferenceItem(ChannelsEnum.CHAT.getCode(), ChannelsEnum.CHAT.getText()));
        channels.add(new ReferenceItem(ChannelsEnum.PHONE.getCode(), ChannelsEnum.PHONE.getText()));
        channels.add(new ReferenceItem(ChannelsEnum.EMAIL.getCode(), ChannelsEnum.EMAIL.getText()));

        // Initiator Types
        this.initiatorTypes = new ArrayList<>();
        initiatorTypes.add(new ReferenceItem(InitiatorTypeEnum.CLIENT.getCode(), InitiatorTypeEnum.CLIENT.getText()));
        initiatorTypes.add(new ReferenceItem(InitiatorTypeEnum.NOT_CLIENT.getCode(), InitiatorTypeEnum.NOT_CLIENT.getText()));
        initiatorTypes.add(new ReferenceItem(InitiatorTypeEnum.PRODUCT.getCode(), InitiatorTypeEnum.PRODUCT.getText()));
        initiatorTypes.add(new ReferenceItem(InitiatorTypeEnum.DELIVERY.getCode(), InitiatorTypeEnum.DELIVERY.getText()));
        initiatorTypes.add(new ReferenceItem(InitiatorTypeEnum.OTHER.getCode(), InitiatorTypeEnum.OTHER.getText()));

        // Divisions
        this.divisions = new ArrayList<>();
        divisions.add(new ReferenceItem(DivisionsEnum.SELLPLUS.getCode(), DivisionsEnum.SELLPLUS.getText()));
        divisions.add(new ReferenceItem(DivisionsEnum.KIK.getCode(), DivisionsEnum.KIK.getText()));
        divisions.add(new ReferenceItem(DivisionsEnum.GUARANTEE.getCode(), DivisionsEnum.GUARANTEE.getText()));
        divisions.add(new ReferenceItem(DivisionsEnum.FACTORING.getCode(), DivisionsEnum.FACTORING.getText()));


        // Priority
        this.priority = new ArrayList<>();
        priority.add(new ReferenceItem(PriorityEnum.CRITICAL.getCode(), PriorityEnum.CRITICAL.getText()));
        priority.add(new ReferenceItem(PriorityEnum.HIGH.getCode(), PriorityEnum.HIGH.getText()));
        priority.add(new ReferenceItem(PriorityEnum.MEDIUM.getCode(), PriorityEnum.MEDIUM.getText()));
        priority.add(new ReferenceItem(PriorityEnum.LOW.getCode(), PriorityEnum.LOW.getText()));
        priority.add(new ReferenceItem(PriorityEnum.PAUSE.getCode(), PriorityEnum.PAUSE.getText()));

        // Statuses
        this.statuses = new ArrayList<>();
        statuses.add(new ReferenceItem(StatusesEnum.DRAFT.getCode(), StatusesEnum.DRAFT.getText()));
        statuses.add(new ReferenceItem(StatusesEnum.NEW.getCode(), StatusesEnum.NEW.getText()));
        statuses.add(new ReferenceItem(StatusesEnum.PENDING.getCode(), StatusesEnum.PENDING.getText()));
        statuses.add(new ReferenceItem(StatusesEnum.IN_PROGRESS.getCode(), StatusesEnum.IN_PROGRESS.getText()));
        statuses.add(new ReferenceItem(StatusesEnum.DONE.getCode(), StatusesEnum.DONE.getText()));

        List<ReferenceItem> doneReasons = StatusesEnum.DONE.getReasons();
        statuses.get(statuses.size() - 1).setReasons(doneReasons);

        List<ReferenceItem> rejectedReasons = StatusesEnum.REJECTED.getReasons();
        statuses.add(new ReferenceItem(StatusesEnum.REJECTED.getCode(), StatusesEnum.REJECTED.getText(), rejectedReasons));

        // ClaimTypes
        this.claimTypes = new ArrayList<>();
        claimTypes.add(new ReferenceItem(ClaimTypesEnum.ERROR.getCode(), ClaimTypesEnum.ERROR.getText()));
        claimTypes.add(new ReferenceItem(ClaimTypesEnum.NAVIGATION.getCode(), ClaimTypesEnum.NAVIGATION.getText()));
        claimTypes.add(new ReferenceItem(ClaimTypesEnum.INQUIRY.getCode(), ClaimTypesEnum.INQUIRY.getText()));
        claimTypes.add(new ReferenceItem(ClaimTypesEnum.DATA_UPDATE.getCode(), ClaimTypesEnum.DATA_UPDATE.getText()));
        claimTypes.add(new ReferenceItem(ClaimTypesEnum.CONSULTATION.getCode(), ClaimTypesEnum.CONSULTATION.getText()));
        claimTypes.add(new ReferenceItem(ClaimTypesEnum.CLOSE_ACCOUNT.getCode(), ClaimTypesEnum.CLOSE_ACCOUNT.getText()));
        claimTypes.add(new ReferenceItem(ClaimTypesEnum.CURRENCY_CONTROL.getCode(), ClaimTypesEnum.CURRENCY_CONTROL.getText()));
        claimTypes.add(new ReferenceItem(ClaimTypesEnum.CB_REQUEST.getCode(), ClaimTypesEnum.CB_REQUEST.getText()));
        claimTypes.add(new ReferenceItem(ClaimTypesEnum.NEW_SERVICE.getCode(), ClaimTypesEnum.NEW_SERVICE.getText()));
        claimTypes.add(new ReferenceItem(ClaimTypesEnum.PROFILE_MANAGEMENT.getCode(), ClaimTypesEnum.PROFILE_MANAGEMENT.getText()));
        claimTypes.add(new ReferenceItem(ClaimTypesEnum.UNKNOWN.getCode(), ClaimTypesEnum.UNKNOWN.getText()));
        claimTypes.add(new ReferenceItem(ClaimTypesEnum.EXTRA_ACCOUNT.getCode(), ClaimTypesEnum.EXTRA_ACCOUNT.getText()));
        claimTypes.add(new ReferenceItem(ClaimTypesEnum.TARIFF_CHANGE.getCode(), ClaimTypesEnum.TARIFF_CHANGE.getText()));
        claimTypes.add(new ReferenceItem(ClaimTypesEnum.NOMINAL_PAYMENT.getCode(), ClaimTypesEnum.NOMINAL_PAYMENT.getText()));
        claimTypes.add(new ReferenceItem(ClaimTypesEnum.CLAIM.getCode(), ClaimTypesEnum.CLAIM.getText()));
        claimTypes.add(new ReferenceItem(ClaimTypesEnum.OTHER.getCode(), ClaimTypesEnum.OTHER.getText()));

        // ClaimThemes
        this.claimThemes = new ArrayList<>();
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.IS_ROWI.getCode(), ClaimThemesEnum.IS_ROWI.getText()));
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.CHAT.getCode(), ClaimThemesEnum.CHAT.getText()));
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.IBANK.getCode(), ClaimThemesEnum.IBANK.getText()));
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.ACCOUNT_OPEN_INQUIRY.getCode(), ClaimThemesEnum.ACCOUNT_OPEN_INQUIRY.getText()));
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.CASH_FLOW_INQUIRY.getCode(), ClaimThemesEnum.CASH_FLOW_INQUIRY.getText()));
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.ACCOUNT_CLOSE_INQUIRY.getCode(), ClaimThemesEnum.ACCOUNT_CLOSE_INQUIRY.getText()));
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.CARD_INDEX_INQUIRY.getCode(), ClaimThemesEnum.CARD_INDEX_INQUIRY.getText()));
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.LOAN_DEBT_INQUIRY.getCode(), ClaimThemesEnum.LOAN_DEBT_INQUIRY.getText()));
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.EXCERPT.getCode(), ClaimThemesEnum.EXCERPT.getText()));
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.VISIT_TO_CLIENT.getCode(), ClaimThemesEnum.VISIT_TO_CLIENT.getText()));
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.NO_VISIT_TO_CLIENT.getCode(), ClaimThemesEnum.NO_VISIT_TO_CLIENT.getText()));
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.TARIFFS.getCode(), ClaimThemesEnum.TARIFFS.getText()));
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.DOCUMENTS.getCode(), ClaimThemesEnum.DOCUMENTS.getText()));
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.ACCOUNT_BLOCK.getCode(), ClaimThemesEnum.ACCOUNT_BLOCK.getText()));
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.PAYMENTS.getCode(), ClaimThemesEnum.PAYMENTS.getText()));
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.INTEREST_ON_BALANCE.getCode(), ClaimThemesEnum.INTEREST_ON_BALANCE.getText()));
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.INITIATED_BY_CLIENT.getCode(), ClaimThemesEnum.INITIATED_BY_CLIENT.getText()));
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.DOCUMENTS_REQUEST.getCode(), ClaimThemesEnum.DOCUMENTS_REQUEST.getText()));
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.BANK_SUPPORT_OF_CONTRACT.getCode(), ClaimThemesEnum.BANK_SUPPORT_OF_CONTRACT.getText()));
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.SUPPORT_OF_PREGIVEN_ACPT.getCode(), ClaimThemesEnum.SUPPORT_OF_PREGIVEN_ACPT.getText()));
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.CREATE_NEW_PROFILE.getCode(), ClaimThemesEnum.CREATE_NEW_PROFILE.getText()));
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.BLOCK_PROFILE.getCode(), ClaimThemesEnum.BLOCK_PROFILE.getText()));
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.UNBLOCK_PROFILE.getCode(), ClaimThemesEnum.UNBLOCK_PROFILE.getText()));
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.LEGAL_SUPPORT_REQUIRED.getCode(), ClaimThemesEnum.LEGAL_SUPPORT_REQUIRED.getText()));
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.LEGAL_SUPPORT_NOT_REQUIRED.getCode(), ClaimThemesEnum.LEGAL_SUPPORT_NOT_REQUIRED.getText()));
        claimThemes.add(new ReferenceItem(ClaimThemesEnum.OTHER.getCode(), ClaimThemesEnum.OTHER.getText()));



    }
}
