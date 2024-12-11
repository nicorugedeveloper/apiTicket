package com.example.PruebaTecnica.domain.repository;

import com.example.PruebaTecnica.domain.modelo.Ticket;

import java.util.Optional;

public interface FindByIdRepository {

    Optional<Ticket> findById(Long id);
}
