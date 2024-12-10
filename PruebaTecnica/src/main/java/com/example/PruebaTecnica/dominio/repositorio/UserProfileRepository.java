package com.example.PruebaTecnica.dominio.repositorio;

import com.example.PruebaTecnica.dominio.modelo.UserProfile;

import java.util.Optional;

public interface UserProfileRepository {

    Optional<UserProfile> findByUsername(String username);
}
