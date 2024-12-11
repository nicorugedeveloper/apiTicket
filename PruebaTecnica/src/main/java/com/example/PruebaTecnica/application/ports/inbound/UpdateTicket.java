package com.example.PruebaTecnica.application.ports.inbound;

import com.example.PruebaTecnica.application.servicio.UpdateTicketService;
import com.example.PruebaTecnica.domain.dto.CreateTicketRequest;
import com.example.PruebaTecnica.domain.modelo.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tickets")
public class UpdateTicket {

    private final UpdateTicketService updateTicketService;

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long id,
                                               @RequestBody CreateTicketRequest request) {
        try {
            Ticket updatedTicket = updateTicketService.updateTicket(id, request);
            return ResponseEntity.ok(updatedTicket);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
