package com.graigjin.localhostbackend.model;

import com.graigjin.localhostbackend.model.enums.EActionItem;

import javax.persistence.*;

@Entity
public class ActionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long actionItemId;

    @Enumerated(EnumType.STRING)
    private EActionItem name;

    public ActionItem() {
    }

    public ActionItem(EActionItem name) {
        this.name = name;
    }

    public long getActionItemId() {
        return actionItemId;
    }

    public void setActionItemId(long actionItemId) {
        this.actionItemId = actionItemId;
    }

    public EActionItem getName() {
        return name;
    }

    public void setName(EActionItem actionItem) {
        this.name = actionItem;
    }
}
