package com.example.PruebaTecnica.dominio.repositorio;

import com.example.PruebaTecnica.dominio.modelo.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketRepository {

    Ticket save(Ticket ticket);
    Optional<Ticket> findById(Long id);
    List<Ticket> findAll(int page, int size);
    List<Ticket> findByStatus(Ticket.Status status, int page, int size);
    void deleteById(Long id);
}
