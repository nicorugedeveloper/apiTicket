package com.example.PruebaTecnica.application.servicio;

import com.example.PruebaTecnica.domain.modelo.Ticket;
import com.example.PruebaTecnica.domain.repository.FindByIdRepository;
import com.example.PruebaTecnica.domain.repository.SaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateTicketService {

    private final FindByIdRepository findByIdRepository;
    private final SaveRepository saveRepository;

    public Ticket updateTicket(Long id, String usuario, Ticket.Status status) {
        Optional<Ticket> existingTicket = findByIdRepository.findById(id);
        if (existingTicket.isEmpty()) {
            throw new IllegalArgumentException("Ticket not found with id: " + id);
        }
        Ticket ticket = existingTicket.get();
        ticket.setUsuario(usuario);
        ticket.setEstatus(status);
        ticket.setFechaActualizacion(LocalDateTime.now());
        return saveRepository.save(ticket);
    }
}
