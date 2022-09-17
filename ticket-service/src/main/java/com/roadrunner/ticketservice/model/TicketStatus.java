package com.roadrunner.ticketservice.model;

public enum TicketStatus {
    OPEN("Aciq"),
    IN_PROGRESS("Üzerinde Isleyirik"),
    RESOLVED("Hell olundu"),
    CLOSED("Qapandi");

    private String label;

    TicketStatus(String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
