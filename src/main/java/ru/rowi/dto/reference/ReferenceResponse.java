package ru.rowi.dto.reference;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
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
        categories.add(new ReferenceItem(CategoriesRefEnum.INCOMING.getCode(), CategoriesRefEnum.INCOMING.getText()));
        categories.add(new ReferenceItem(CategoriesRefEnum.OUTGOING.getCode(), CategoriesRefEnum.OUTGOING.getText()));

        // Channels
        this.channels = new ArrayList<>();
        channels.add(new ReferenceItem(ChannelsRefEnum.CHAT.getCode(), ChannelsRefEnum.CHAT.getText()));
        channels.add(new ReferenceItem(ChannelsRefEnum.PHONE.getCode(), ChannelsRefEnum.PHONE.getText()));
        channels.add(new ReferenceItem(ChannelsRefEnum.EMAIL.getCode(), ChannelsRefEnum.EMAIL.getText()));

        // Initiator Types
        this.initiatorTypes = new ArrayList<>();
        initiatorTypes.add(new ReferenceItem(InitiatorTypeRefEnum.CLIENT.getCode(), InitiatorTypeRefEnum.CLIENT.getText()));
        initiatorTypes.add(new ReferenceItem(InitiatorTypeRefEnum.NOT_CLIENT.getCode(), InitiatorTypeRefEnum.NOT_CLIENT.getText()));
        initiatorTypes.add(new ReferenceItem(InitiatorTypeRefEnum.PRODUCT.getCode(), InitiatorTypeRefEnum.PRODUCT.getText()));
        initiatorTypes.add(new ReferenceItem(InitiatorTypeRefEnum.DELIVERY.getCode(), InitiatorTypeRefEnum.DELIVERY.getText()));
        initiatorTypes.add(new ReferenceItem(InitiatorTypeRefEnum.OTHER.getCode(), InitiatorTypeRefEnum.OTHER.getText()));

        // Divisions
        this.divisions = new ArrayList<>();
        divisions.add(new ReferenceItem(DivisionsRefEnum.SELLPLUS.getCode(), DivisionsRefEnum.SELLPLUS.getText()));
        divisions.add(new ReferenceItem(DivisionsRefEnum.KIK.getCode(), DivisionsRefEnum.KIK.getText()));
        divisions.add(new ReferenceItem(DivisionsRefEnum.GUARANTEE.getCode(), DivisionsRefEnum.GUARANTEE.getText()));
        divisions.add(new ReferenceItem(DivisionsRefEnum.FACTORING.getCode(), DivisionsRefEnum.FACTORING.getText()));


        // Priority
        this.priority = new ArrayList<>();
        priority.add(new ReferenceItem(PriorityRefEnum.CRITICAL.getCode(), PriorityRefEnum.CRITICAL.getText()));
        priority.add(new ReferenceItem(PriorityRefEnum.HIGH.getCode(), PriorityRefEnum.HIGH.getText()));
        priority.add(new ReferenceItem(PriorityRefEnum.MEDIUM.getCode(), PriorityRefEnum.MEDIUM.getText()));
        priority.add(new ReferenceItem(PriorityRefEnum.LOW.getCode(), PriorityRefEnum.LOW.getText()));
        priority.add(new ReferenceItem(PriorityRefEnum.PAUSE.getCode(), PriorityRefEnum.PAUSE.getText()));

        // Statuses
        this.statuses = new ArrayList<>();
        statuses.add(new ReferenceItem(StatusesRefEnum.DRAFT.getCode(), StatusesRefEnum.DRAFT.getText()));
        statuses.add(new ReferenceItem(StatusesRefEnum.NEW.getCode(), StatusesRefEnum.NEW.getText()));
        statuses.add(new ReferenceItem(StatusesRefEnum.PENDING.getCode(), StatusesRefEnum.PENDING.getText()));
        statuses.add(new ReferenceItem(StatusesRefEnum.IN_PROGRESS.getCode(), StatusesRefEnum.IN_PROGRESS.getText()));
        statuses.add(new ReferenceItem(StatusesRefEnum.DONE.getCode(), StatusesRefEnum.DONE.getText()));

        List<ReferenceItem> doneReasons = StatusesRefEnum.DONE.getReasons();
        statuses.get(statuses.size() - 1).setReasons(doneReasons);

        List<ReferenceItem> rejectedReasons = StatusesRefEnum.REJECTED.getReasons();
        statuses.add(new ReferenceItem(StatusesRefEnum.REJECTED.getCode(), StatusesRefEnum.REJECTED.getText(), rejectedReasons));
    }
}
