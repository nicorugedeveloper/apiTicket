package com.example.PruebaTecnica.application.ports.inbound;

import com.example.PruebaTecnica.application.servicio.GetAllTicketsService;
import com.example.PruebaTecnica.domain.modelo.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tickets")
public class GetAllTickets {

    private final GetAllTicketsService getAllTicketsService;

    @GetMapping
    public List<Ticket> getTickets(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        return getAllTicketsService.getAllTickets(page, size);
    }
}
