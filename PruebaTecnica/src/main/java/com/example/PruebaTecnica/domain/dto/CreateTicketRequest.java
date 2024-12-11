package com.example.PruebaTecnica.domain.dto;

import com.example.PruebaTecnica.domain.modelo.Ticket;
import lombok.Data;

@Data
public class CreateTicketRequest {
    private String usuario;
    private Ticket.Status estatus;
}
