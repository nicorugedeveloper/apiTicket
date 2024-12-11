package com.example.PruebaTecnica.application.servicio;

import com.example.PruebaTecnica.domain.modelo.Ticket;
import com.example.PruebaTecnica.domain.repository.FindByStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetTicketsByStatusService {

    private final FindByStatusRepository findByStatusRepository;

    public List<Ticket> getTicketsByStatus(Ticket.Status status, int page, int size) {
        return findByStatusRepository.findByStatus(status, page, size);
    }
}
