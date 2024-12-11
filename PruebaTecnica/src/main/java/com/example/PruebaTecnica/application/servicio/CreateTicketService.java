package com.example.PruebaTecnica.application.servicio;

import com.example.PruebaTecnica.domain.modelo.Ticket;
import com.example.PruebaTecnica.domain.repository.SaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateTicketService {

    private final SaveRepository saveRepository;

    public Ticket createTicket(String usuario, Ticket.Status status) {
        Ticket ticket = new Ticket(null, usuario, LocalDateTime.now(), LocalDateTime.now(), status);
        return saveRepository.save(ticket);
    }
}
