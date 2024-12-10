package com.example.PruebaTecnica.dominio.servicio;

import com.example.PruebaTecnica.dominio.modelo.UserProfile;
import com.example.PruebaTecnica.dominio.repositorio.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public Optional<UserProfile> getUserProfileByUsername(String username) {
        return userProfileRepository.findByUsername(username);
    }
}
