package com.example.PruebaTecnica.domain.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {

    private Long id;
    private String nombreUsuario;
    private String nombreCompleto;
    private String email;
    private int repositoriosPublicos;
}
