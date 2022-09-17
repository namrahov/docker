package com.roadrunner.ticketservice.dto;

import java.io.Serializable;
import java.util.Date;

public class TicketDto implements Serializable {
    private static final long serialVersionUID = -5231696277258369542L;

    public TicketDto() {
    }

    public TicketDto(String id, String description, String notes, String assignee, Date ticketDate, String priorityType, String ticketStatus) {
        this.id = id;
        this.description = description;
        this.notes = notes;
        this.assignee = assignee;
        this.ticketDate = ticketDate;
        this.priorityType = priorityType;
        this.ticketStatus = ticketStatus;
    }

    private String id;

    private String description;

    private String notes;

    private String assignee;

    private Date ticketDate;

    private String priorityType;

    private String ticketStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Date getTicketDate() {
        return ticketDate;
    }


    public void setTicketDate(Date ticketDate) {
        this.ticketDate = ticketDate;
    }

    public String getPriorityType() {
        return priorityType;
    }

    public void setPriorityType(String priorityType) {
        this.priorityType = priorityType;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    @Override
    public String toString() {
        return "TicketDto{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", notes='" + notes + '\'' +
                ", assignee='" + assignee + '\'' +
                ", ticketDate=" + ticketDate +
                ", priorityType='" + priorityType + '\'' +
                ", ticketStatus='" + ticketStatus + '\'' +
                '}';
    }
}