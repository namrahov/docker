package com.roadrunner.ticketservice.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Builder
@Table(name = "ticket")
public class Ticket implements Serializable {

    public Ticket() {
    }


    public Ticket(String id, String description, String notes, String assignee, Date ticketDate, PriorityType priorityType, TicketStatus ticketStatus) {
        this.id = id;
        this.description = description;
        this.notes = notes;
        this.assignee = assignee;
        this.ticketDate = ticketDate;
        this.priorityType = priorityType;
        this.ticketStatus = ticketStatus;
    }



    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "description", length = 600)
    private String description;

    @Column(name = "notes", length = 1000)
    private String notes;

    @Column(name = "assignee", length = 50)
    private String assignee;

    @Column(name = "ticket_date")
    private Date ticketDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "priority_type")
    private PriorityType priorityType;


    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ticket_status")
    private TicketStatus ticketStatus;

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getNotes() {
        return notes;
    }

    public String getAssignee() {
        return assignee;
    }

    public Date getTicketDate() {
        return ticketDate;
    }

    public PriorityType getPriorityType() {
        return priorityType;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public void setTicketDate(Date ticketDate) {
        this.ticketDate = ticketDate;
    }

    public void setPriorityType(PriorityType priorityType) {
        this.priorityType = priorityType;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", notes='" + notes + '\'' +
                ", assignee='" + assignee + '\'' +
                ", ticketDate=" + ticketDate +
                ", priorityType=" + priorityType +
                ", ticketStatus=" + ticketStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}