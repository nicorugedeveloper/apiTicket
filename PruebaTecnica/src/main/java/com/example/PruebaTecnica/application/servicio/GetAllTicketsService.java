package com.example.PruebaTecnica.application.servicio;

import com.example.PruebaTecnica.domain.modelo.Ticket;
import com.example.PruebaTecnica.domain.repository.FindAllRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllTicketsService {

    private final FindAllRepository findAllRepository;

    public List<Ticket> getAllTickets(int page, int size) {
        return findAllRepository.findAll(page, size);
    }

}
