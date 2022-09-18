package com.roadrunner.notificationservice.service;

import com.roadrunner.notificationservice.messaging.TicketNotification;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class NotificationDistribationService {

    @StreamListener(Sink.INPUT)
    public void onNotification(TicketNotification ticketNotification){
        System.out.println("-------------------------------------------");
        System.out.println("Notification alindi ve istifadecilere gonderiir ");
        System.out.println("Notification => " + ticketNotification.toString());

    }
}
