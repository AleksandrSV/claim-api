package ru.rowi.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.rowi.dto.reference.*;
import ru.rowi.dto.reference.ReferenceItem;

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
    }
}
