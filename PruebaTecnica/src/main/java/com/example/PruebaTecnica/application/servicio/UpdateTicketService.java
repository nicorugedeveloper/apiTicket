package com.example.PruebaTecnica.application.servicio;

import com.example.PruebaTecnica.domain.dto.CreateTicketRequest;
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

    public Ticket updateTicket(Long id, CreateTicketRequest request) {
        // Buscar el ticket existente por ID
        Optional<Ticket> existingTicket = findByIdRepository.findById(id);
        if (existingTicket.isEmpty()) {
            throw new IllegalArgumentException("Ticket not found with id: " + id);
        }

        // Actualizar los campos del ticket
        Ticket ticket = existingTicket.get();
        ticket.setUsuario(request.getUsuario());
        ticket.setEstatus(request.getEstatus());
        ticket.setFechaActualizacion(LocalDateTime.now());

        // Guardar el ticket actualizado
        return saveRepository.save(ticket);
    }
}
