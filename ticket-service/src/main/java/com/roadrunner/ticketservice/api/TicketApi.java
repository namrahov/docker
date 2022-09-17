package com.roadrunner.ticketservice.api;

import com.roadrunner.ticketservice.dto.TicketDto;
import com.roadrunner.ticketservice.model.Ticket;
import com.roadrunner.ticketservice.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/ticket")
@RestController
public class TicketApi {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getById(@PathVariable String id) {
        Optional<Ticket> optionalTicket = ticketService.getById(id);
        Ticket ticket = optionalTicket.get();
            return ResponseEntity.ok(ticket);
    }

    @PostMapping
    public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketDto) {
        return ResponseEntity.ok(ticketService.save(ticketDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketDto> updateTicket(@PathVariable String id,
                                                  @RequestBody TicketDto ticketDto) {
        return ResponseEntity.ok(ticketService.update(id, ticketDto));
    }

    @GetMapping
    public ResponseEntity<Page<TicketDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok(ticketService.getPagination(pageable));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        ticketService.delete(id);
    }
}