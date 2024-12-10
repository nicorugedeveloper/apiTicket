package com.example.PruebaTecnica.dominio.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTicket;

    @Column(nullable = false, length = 100)
    private String usuario;

    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaActualizacion;

    @Enumerated(EnumType.STRING)
    private Estatus estatus;

    public enum Estatus {
        ABIERTO,
        CERRADO
    }
}
