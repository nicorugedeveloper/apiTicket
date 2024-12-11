package com.example.PruebaTecnica.infraestructure.persistencia.repositorio;

import com.example.PruebaTecnica.domain.modelo.Ticket;
import com.example.PruebaTecnica.domain.repository.FindByIdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FindByIdTicketImpl implements FindByIdRepository {

    private final TicketJpaRepository jpaRepository;
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
}
