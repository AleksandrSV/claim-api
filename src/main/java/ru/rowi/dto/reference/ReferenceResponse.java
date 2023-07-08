package ru.rowi.dto.reference;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
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
        categories.add(new ReferenceItem(ReferenceEnum.INCOMING.getCode(), ReferenceEnum.INCOMING.getText()));
        categories.add(new ReferenceItem(ReferenceEnum.OUTGOING.getCode(), ReferenceEnum.OUTGOING.getText()));

        // Channels
        this.channels = new ArrayList<>();
        channels.add(new ReferenceItem(ReferenceEnum.CHAT.getCode(), ReferenceEnum.CHAT.getText()));
        channels.add(new ReferenceItem(ReferenceEnum.PHONE.getCode(), ReferenceEnum.PHONE.getText()));
        channels.add(new ReferenceItem(ReferenceEnum.EMAIL.getCode(), ReferenceEnum.EMAIL.getText()));

        // Initiator Types
        this.initiatorTypes = new ArrayList<>();
        initiatorTypes.add(new ReferenceItem(ReferenceEnum.CLIENT.getCode(), ReferenceEnum.CLIENT.getText()));
        initiatorTypes.add(new ReferenceItem(ReferenceEnum.NOT_CLIENT.getCode(), ReferenceEnum.NOT_CLIENT.getText()));
        initiatorTypes.add(new ReferenceItem(ReferenceEnum.PRODUCT.getCode(), ReferenceEnum.PRODUCT.getText()));
        initiatorTypes.add(new ReferenceItem(ReferenceEnum.DELIVERY.getCode(), ReferenceEnum.DELIVERY.getText()));
        initiatorTypes.add(new ReferenceItem(ReferenceEnum.OTHER.getCode(), ReferenceEnum.OTHER.getText()));

        // Divisions
        this.divisions = new ArrayList<>();
        divisions.add(new ReferenceItem(ReferenceEnum.SELLPLUS.getCode(), ReferenceEnum.SELLPLUS.getText()));
        divisions.add(new ReferenceItem(ReferenceEnum.KIK.getCode(), ReferenceEnum.KIK.getText()));
        divisions.add(new ReferenceItem(ReferenceEnum.GUARANTEE.getCode(), ReferenceEnum.GUARANTEE.getText()));
        divisions.add(new ReferenceItem(ReferenceEnum.FACTORING.getCode(), ReferenceEnum.FACTORING.getText()));


        // Priority
        this.priority = new ArrayList<>();
        priority.add(new ReferenceItem(ReferenceEnum.CRITICAL.getCode(), ReferenceEnum.CRITICAL.getText()));
        priority.add(new ReferenceItem(ReferenceEnum.HIGH.getCode(), ReferenceEnum.HIGH.getText()));
        priority.add(new ReferenceItem(ReferenceEnum.MEDIUM.getCode(), ReferenceEnum.MEDIUM.getText()));
        priority.add(new ReferenceItem(ReferenceEnum.LOW.getCode(), ReferenceEnum.LOW.getText()));
        priority.add(new ReferenceItem(ReferenceEnum.PAUSE.getCode(), ReferenceEnum.PAUSE.getText()));

        // Statuses
        this.statuses = new ArrayList<>();
        statuses.add(new ReferenceItem(ReferenceEnum.DRAFT.getCode(), ReferenceEnum.DRAFT.getText()));
        statuses.add(new ReferenceItem(ReferenceEnum.NEW.getCode(), ReferenceEnum.NEW.getText()));
        statuses.add(new ReferenceItem(ReferenceEnum.PENDING.getCode(), ReferenceEnum.PENDING.getText()));
        statuses.add(new ReferenceItem(ReferenceEnum.IN_PROGRESS.getCode(), ReferenceEnum.IN_PROGRESS.getText()));
        statuses.add(new ReferenceItem(ReferenceEnum.DONE.getCode(), ReferenceEnum.DONE.getText()));

        List<ReferenceItem> doneReasons = new ArrayList<>();
        doneReasons.add(new ReferenceItem(ReferenceEnum.DONE.getCode(), "Закрыто"));
        doneReasons.add(new ReferenceItem(ReferenceEnum.FORWARDED.getCode(), "Переведено в другое подразделение"));
        statuses.get(statuses.size() - 1).setReasons(doneReasons);

        List<ReferenceItem> rejectedReasons = new ArrayList<>();
        rejectedReasons.add(new ReferenceItem(ReferenceEnum.INITIATOR_REJECTED.getCode(), "Отказ инициатора"));
        rejectedReasons.add(new ReferenceItem(ReferenceEnum.WRONG_CREATED.getCode(), "Ошибочно заведено"));
        rejectedReasons.add(new ReferenceItem(ReferenceEnum.DUPLICATE.getCode(), "Дубликат"));
        statuses.add(new ReferenceItem(ReferenceEnum.REJECTED.getCode(), ReferenceEnum.REJECTED.getText(), rejectedReasons));
    }
}
