package com.example.PruebaTecnica.dominio.modelo;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    private Long id;
    private String usuario;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private Status estatus;

    public enum Status {
        ABIERTO,
        CERRADO
    }
}
