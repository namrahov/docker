package com.roadrunner.ticketservice.service.impl;


import com.roadrunner.ticketservice.messaging.TicketNotification;
import com.roadrunner.ticketservice.model.Ticket;
import com.roadrunner.ticketservice.service.TicketNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Source.class)
public class TicketNotificationServiceImpl implements TicketNotificationService {

    @Autowired
    private Source source;

    @Override
    public void sendtoQueue(Ticket ticket) {

        TicketNotification ticketNotification = new TicketNotification();
        ticketNotification.setAccountId(ticket.getAssignee());
        ticketNotification.setTicketId(ticket.getId());
        ticketNotification.setTicketDescription(ticket.getDescription());

        source.output().send(MessageBuilder.withPayload(ticketNotification).build());
    }


}
