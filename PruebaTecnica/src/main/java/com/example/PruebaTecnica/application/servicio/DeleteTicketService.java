package com.example.PruebaTecnica.application.servicio;

import com.example.PruebaTecnica.domain.repository.DeleteByIdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteTicketService {

    private final DeleteByIdRepository deleteByIdRepository;

    public void deleteTicket(Long id) {
        deleteByIdRepository.deleteById(id);
    }
}
