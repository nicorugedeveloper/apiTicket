package com.example.PruebaTecnica.application.servicio;

import com.example.PruebaTecnica.domain.modelo.Ticket;
import com.example.PruebaTecnica.domain.repository.FindByIdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetTicketByIdService {

    private final FindByIdRepository findByIdRepository;

    public Optional<Ticket> getTicketById(Long id) {
        return findByIdRepository.findById(id);
    }
}
