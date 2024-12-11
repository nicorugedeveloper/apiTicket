package com.example.PruebaTecnica.infraestructure.persistencia.repositorio;

import com.example.PruebaTecnica.infraestructure.persistencia.entidad.TicketEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketJpaRepository extends JpaRepository<TicketEntity, Long> {
    List<TicketEntity> findByEstatus(TicketEntity.Status estatus);
    Page<TicketEntity> findAll(Pageable pageable);
}
