package com.example.PruebaTecnica.infraestructura.persistencia.repositorio;

import com.example.PruebaTecnica.dominio.modelo.Ticket;
import com.example.PruebaTecnica.dominio.repositorio.TicketRepository;
import com.example.PruebaTecnica.infraestructura.persistencia.entidad.TicketEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TicketRepositoryImpl implements TicketRepository {
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

    @Override
    public Optional<Ticket> findById(Long id) {
        return jpaRepository.findById(id).map(entity -> new Ticket(
                entity.getId(),
                entity.getUsuario(),
                entity.getFechaCreacion(),
                entity.getFechaActualizacion(),
                Ticket.Status.valueOf(entity.getEstatus().name())
        ));
    }

    @Override
    public List<Ticket> findAll(int page, int size) {
        return jpaRepository.findAll()
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

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
