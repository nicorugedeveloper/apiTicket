package com.example.PruebaTecnica.infraestructura.persistencia.repositorio;

import com.example.PruebaTecnica.infraestructura.persistencia.entidad.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketJpaRepository extends JpaRepository<TicketEntity, Long> {
    List<TicketEntity> findByEstatus(TicketEntity.Status estatus);
}
