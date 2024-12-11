package com.example.PruebaTecnica.infraestructure.persistencia.repositorio;

import com.example.PruebaTecnica.domain.modelo.Ticket;
import com.example.PruebaTecnica.domain.repository.SaveRepository;
import com.example.PruebaTecnica.infraestructure.persistencia.entidad.TicketEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SaveTicketImpl implements SaveRepository {

    private final TicketJpaRepository jpaRepository;
    @Override
    public Ticket save(Ticket ticket) {
        TicketEntity entity = new TicketEntity(
                ticket.getId(),
                ticket.getUsuario(),
                ticket.getFechaCreacion(),
                ticket.getFechaActualizacion(),
                TicketEntity.Status.valueOf(ticket.getEstatus().name())
        );
        TicketEntity savedEntity = jpaRepository.save(entity);
        return new Ticket(
                savedEntity.getId(),
                savedEntity.getUsuario(),
                savedEntity.getFechaCreacion(),
                savedEntity.getFechaActualizacion(),
                Ticket.Status.valueOf(savedEntity.getEstatus().name())
        );
    }
}
