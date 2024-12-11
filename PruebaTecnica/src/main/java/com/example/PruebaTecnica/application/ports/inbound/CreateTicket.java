package com.example.PruebaTecnica.application.ports.inbound;

import com.example.PruebaTecnica.application.servicio.CreateTicketService;
import com.example.PruebaTecnica.domain.dto.CreateTicketRequest;
import com.example.PruebaTecnica.domain.dto.TicketDTO;
import com.example.PruebaTecnica.domain.modelo.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tickets")
public class CreateTicket {

    private final CreateTicketService createTicketService;

    @PostMapping
    public ResponseEntity<TicketDTO> createTicket(@RequestBody CreateTicketRequest request) {
        Ticket ticket = createTicketService.createTicket(request.getUsuario(), request.getEstatus());
        TicketDTO ticketDTO = new TicketDTO(
                ticket.getId(),
                ticket.getUsuario(),
                ticket.getFechaCreacion(),
                ticket.getFechaActualizacion(),
                ticket.getEstatus()
        );
        return new ResponseEntity<>(ticketDTO, HttpStatus.CREATED);
    }
}
