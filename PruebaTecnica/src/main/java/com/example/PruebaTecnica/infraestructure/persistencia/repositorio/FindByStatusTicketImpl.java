package com.example.PruebaTecnica.infraestructure.persistencia.repositorio;

import com.example.PruebaTecnica.domain.modelo.Ticket;
import com.example.PruebaTecnica.domain.repository.FindByStatusRepository;
import com.example.PruebaTecnica.infraestructure.persistencia.entidad.TicketEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class FindByStatusTicketImpl implements FindByStatusRepository {

    private final TicketJpaRepository jpaRepository;
    @Override
    public List<Ticket> findByStatus(Ticket.Status status, int page, int size) {
        return jpaRepository.findByEstatus(TicketEntity.Status.valueOf(status.name()))
                .stream()
                .map(entity -> new Ticket(
                        entity.getId(),
                        entity.getUsuario(),
                        entity.getFechaCreacion(),
                        entity.getFechaActualizacion(),
                        Ticket.Status.valueOf(entity.getEstatus().name())
                ))
                .collect(Collectors.toList());
    }
}
