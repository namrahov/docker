package com.roadrunner.ticketservice.service.impl;


import com.roadrunner.client.AccountServiceClient;
import com.roadrunner.client.contract.AccountDto;
import com.roadrunner.ticketservice.dto.TicketDto;
import com.roadrunner.ticketservice.model.PriorityType;
import com.roadrunner.ticketservice.model.Ticket;
import com.roadrunner.ticketservice.model.TicketStatus;
import com.roadrunner.ticketservice.repository.TicketRepository;
import com.roadrunner.ticketservice.service.TicketNotificationService;
import com.roadrunner.ticketservice.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketNotificationService ticketNotificationService;

    @Autowired
    private AccountServiceClient accountServiceClient;


    @Override
    public TicketDto save(TicketDto ticketDto) {
        // Ticket Entity
        if (ticketDto.getDescription() == null)
            throw new IllegalArgumentException("Description bos olamaz");

        Ticket ticket = new Ticket();
        ResponseEntity<AccountDto> accountDtoResponseEntity = accountServiceClient.get(ticketDto.getAssignee());

        ticket.setDescription(ticketDto.getDescription());
        ticket.setNotes(ticketDto.getNotes());
        ticket.setTicketDate(ticketDto.getTicketDate());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));
        ticket.setAssignee(accountDtoResponseEntity.getBody().getId());


        // mysql-e yaz
        ticket = ticketRepository.save(ticket);


        // TicketModel obyekti

        TicketDto model = new TicketDto();
        model.setDescription(ticket.getDescription());
        model.setNotes(ticket.getNotes());
        model.setId(ticket.getId());
        model.setAssignee(accountDtoResponseEntity.getBody().getId());
        model.setPriorityType(ticket.getPriorityType().getLabel());
        model.setTicketStatus(ticket.getTicketStatus().getLabel());
        model.setTicketDate(ticket.getTicketDate());

        // elastice yaz
       // ticketElasticRepository.save(model);

        // yarananan obekti qaytar
        ticketDto.setId(ticket.getId());

        // Quyruga notification gonder
        ticketNotificationService.sendtoQueue(ticket);

        return ticketDto;
    }

    @Override
    public TicketDto update(String id, TicketDto ticketDto) {
        return null;
    }

    @Override
    public Optional<Ticket> getById(String ticketId) {
        return ticketRepository.findById(ticketId);
    }

    @Override
    public Page<TicketDto> getPagination(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(String id) {
        ticketRepository.deleteById(id);
    }
}