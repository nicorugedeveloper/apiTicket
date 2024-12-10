package com.example.PruebaTecnica.aplicacion.controlador;

import com.example.PruebaTecnica.aplicacion.dto.CreateTicketRequest;
import com.example.PruebaTecnica.aplicacion.dto.TicketDTO;
import com.example.PruebaTecnica.dominio.modelo.Ticket;
import com.example.PruebaTecnica.dominio.servicio.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketDTO> createTicket(@RequestBody CreateTicketRequest request) {
        Ticket ticket = ticketService.createTicket(request.getUsuario(), request.getEstatus());
        TicketDTO ticketDTO = new TicketDTO(
                ticket.getId(),
                ticket.getUsuario(),
                ticket.getFechaCreacion(),
                ticket.getFechaActualizacion(),
                ticket.getEstatus()
        );
        return new ResponseEntity<>(ticketDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Optional<Ticket> ticket = ticketService.getTicketById(id);
        return ticket.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets(@RequestParam int page, @RequestParam int size) {
        List<Ticket> tickets = ticketService.getAllTickets(page, size);
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/status")
    public ResponseEntity<List<Ticket>> getTicketsByStatus(@RequestParam Ticket.Status status,
                                                           @RequestParam int page,
                                                           @RequestParam int size) {
        List<Ticket> tickets = ticketService.getTicketsByStatus(status, page, size);
        return ResponseEntity.ok(tickets);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long id,
                                               @RequestParam String usuario,
                                               @RequestParam Ticket.Status status) {
        try {
            Ticket updatedTicket = ticketService.updateTicket(id, usuario, status);
            return ResponseEntity.ok(updatedTicket);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
