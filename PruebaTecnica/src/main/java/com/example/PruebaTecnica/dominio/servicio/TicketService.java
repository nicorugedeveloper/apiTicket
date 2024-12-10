package com.example.PruebaTecnica.dominio.servicio;

import com.example.PruebaTecnica.dominio.modelo.Ticket;
import com.example.PruebaTecnica.dominio.repositorio.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    public Ticket createTicket(String usuario, Ticket.Status status) {
        Ticket ticket = new Ticket(null, usuario, LocalDateTime.now(), LocalDateTime.now(), status);
        return ticketRepository.save(ticket);
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public List<Ticket> getAllTickets(int page, int size) {
        return ticketRepository.findAll(page, size);
    }

    public List<Ticket> getTicketsByStatus(Ticket.Status status, int page, int size) {
        return ticketRepository.findByStatus(status, page, size);
    }

    public Ticket updateTicket(Long id, String usuario, Ticket.Status status) {
        Optional<Ticket> existingTicket = ticketRepository.findById(id);
        if (existingTicket.isEmpty()) {
            throw new IllegalArgumentException("Ticket not found with id: " + id);
        }
        Ticket ticket = existingTicket.get();
        ticket.setUsuario(usuario);
        ticket.setEstatus(status);
        ticket.setFechaActualizacion(LocalDateTime.now());
        return ticketRepository.save(ticket);
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
