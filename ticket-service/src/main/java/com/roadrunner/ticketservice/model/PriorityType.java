package com.roadrunner.ticketservice.model;


public enum PriorityType {
    URGENT("Tecili"),
    LOW("Önemsiz"),
    HIGH("Birinci");

    private String label;

    PriorityType(String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
