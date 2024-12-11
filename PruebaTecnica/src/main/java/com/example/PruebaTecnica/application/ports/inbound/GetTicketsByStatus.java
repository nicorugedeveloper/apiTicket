package com.example.PruebaTecnica.application.ports.inbound;

import com.example.PruebaTecnica.application.servicio.GetTicketsByStatusService;
import com.example.PruebaTecnica.domain.modelo.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tickets")
public class GetTicketsByStatus {

    private final GetTicketsByStatusService getTicketsByStatusService;

    @GetMapping("/status")
    public ResponseEntity<List<Ticket>> getTicketsByStatus(@RequestParam Ticket.Status status,
                                                           @RequestParam int page,
                                                           @RequestParam int size) {
        List<Ticket> tickets = getTicketsByStatusService.getTicketsByStatus(status, page, size);
        return ResponseEntity.ok(tickets);
    }
}
