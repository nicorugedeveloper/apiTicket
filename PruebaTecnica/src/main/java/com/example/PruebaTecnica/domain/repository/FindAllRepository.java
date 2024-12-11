package com.example.PruebaTecnica.domain.repository;

import com.example.PruebaTecnica.domain.modelo.Ticket;

import java.util.List;

public interface FindAllRepository {

    List<Ticket> findAll(int page, int size);
}
