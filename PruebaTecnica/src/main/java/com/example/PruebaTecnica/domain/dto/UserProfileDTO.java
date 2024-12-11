package com.example.PruebaTecnica.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDTO {
    private Long id;
    private String nombreUsuario;
    private String nombreCompleto;
    private String email;
    private int repositoriosPublicos;
}
