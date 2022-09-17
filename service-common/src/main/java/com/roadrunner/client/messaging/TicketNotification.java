package com.roadrunner.client.messaging;


public class TicketNotification {
    public TicketNotification() {
    }

    public TicketNotification(String ticketId, String accountId, String ticketDescription) {
        this.ticketId = ticketId;
        this.accountId = accountId;
        this.ticketDescription = ticketDescription;
    }

    private String ticketId;
    private String accountId;
    private String ticketDescription;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getTicketDescription() {
        return ticketDescription;
    }

    public void setTicketDescription(String ticketDescription) {
        this.ticketDescription = ticketDescription;
    }

    @Override
    public String toString() {
        return "TicketNotification{" +
                "ticketId='" + ticketId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", ticketDescription='" + ticketDescription + '\'' +
                '}';
    }
}
