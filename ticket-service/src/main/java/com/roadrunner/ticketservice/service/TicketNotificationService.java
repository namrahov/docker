package com.roadrunner.ticketservice.service;

import com.roadrunner.ticketservice.model.Ticket;

public interface TicketNotificationService {
    void sendtoQueue(Ticket ticket);
}
