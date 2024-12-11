package com.example.PruebaTecnica.infraestructure.persistencia.repositorio;

import com.example.PruebaTecnica.domain.modelo.Ticket;
import com.example.PruebaTecnica.domain.repository.FindAllRepository;
import com.example.PruebaTecnica.infraestructure.persistencia.entidad.TicketEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class FindAllTicketImpl implements FindAllRepository {

    private final TicketJpaRepository jpaRepository;

    @Override
    public List<Ticket> findAll(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<TicketEntity> ticketPage = jpaRepository.findAll(pageable);

        // Depuración: Imprime el tamaño de los datos devueltos
        System.out.println("Total tickets in page: " + ticketPage.getContent().size());

        return ticketPage.getContent().stream()
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
