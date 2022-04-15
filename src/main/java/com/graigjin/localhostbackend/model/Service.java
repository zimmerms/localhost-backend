package com.graigjin.localhostbackend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long serviceId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "action_item_id")
    private ActionItem actionItem;

    private boolean pfChanged;
    private boolean pfCleaned;
    private boolean evCleaned;
    private Date nextService;

    public Service() {
    }

    public Service(ActionItem actionItem, boolean pfChanged, boolean pfCleaned, boolean evCleaned, Date nextService) {
        this.actionItem = actionItem;
        this.pfChanged = pfChanged;
        this.pfCleaned = pfCleaned;
        this.evCleaned = evCleaned;
        this.nextService = nextService;
    }

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }

    public ActionItem getActionItem() {
        return actionItem;
    }

    public void setActionItem(ActionItem actionItem) {
        this.actionItem = actionItem;
    }

    public boolean isPfChanged() {
        return pfChanged;
    }

    public void setPfChanged(boolean pfChanged) {
        this.pfChanged = pfChanged;
    }

    public boolean isPfCleaned() {
        return pfCleaned;
    }

    public void setPfCleaned(boolean pfCleaned) {
        this.pfCleaned = pfCleaned;
    }

    public boolean isEvCleaned() {
        return evCleaned;
    }

    public void setEvCleaned(boolean evCleaned) {
        this.evCleaned = evCleaned;
    }

    public Date getNextService() {
        return nextService;
    }

    public void setNextService(Date nextService) {
        this.nextService = nextService;
    }
}
