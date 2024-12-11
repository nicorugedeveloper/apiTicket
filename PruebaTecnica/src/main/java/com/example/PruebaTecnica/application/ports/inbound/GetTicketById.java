package com.example.PruebaTecnica.application.ports.inbound;

import com.example.PruebaTecnica.application.servicio.GetTicketByIdService;
import com.example.PruebaTecnica.domain.modelo.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tickets")
public class GetTicketById {

    private final GetTicketByIdService getTicketByIdService;

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Optional<Ticket> ticket = getTicketByIdService.getTicketById(id);
        return ticket.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
