package com.example.PruebaTecnica.aplicacion.dto;

import com.example.PruebaTecnica.dominio.modelo.Ticket;
import lombok.Data;

@Data
public class CreateTicketRequest {
    private String usuario;
    private Ticket.Status estatus;
}
