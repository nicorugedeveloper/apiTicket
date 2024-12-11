package com.example.PruebaTecnica.domain.repository;

import com.example.PruebaTecnica.domain.modelo.Ticket;

import java.util.List;

public interface FindByStatusRepository {

    List<Ticket> findByStatus(Ticket.Status status, int page, int size);
}
