package com.example.PruebaTecnica.domain.repository;

import com.example.PruebaTecnica.domain.modelo.Ticket;

public interface SaveRepository {

    Ticket save(Ticket ticket);
}
