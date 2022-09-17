package com.roadrunner.ticketservice.service;

import com.roadrunner.ticketservice.dto.TicketDto;
import com.roadrunner.ticketservice.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TicketService {

    TicketDto save(TicketDto ticketDto);

    TicketDto update(String id, TicketDto ticketDto);

    Optional<Ticket> getById(String ticketId);

    Page<TicketDto> getPagination(Pageable pageable);

    void delete(String id);
}