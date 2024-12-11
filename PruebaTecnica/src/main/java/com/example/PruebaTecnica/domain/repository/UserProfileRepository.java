package com.example.PruebaTecnica.domain.repository;

import com.example.PruebaTecnica.domain.modelo.UserProfile;

import java.util.Optional;

public interface UserProfileRepository {

    Optional<UserProfile> findByUsername(String username);
}
