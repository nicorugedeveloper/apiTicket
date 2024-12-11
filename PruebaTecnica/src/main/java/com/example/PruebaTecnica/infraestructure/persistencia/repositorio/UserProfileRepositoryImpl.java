package com.example.PruebaTecnica.infraestructure.persistencia.repositorio;

import com.example.PruebaTecnica.domain.modelo.UserProfile;
import com.example.PruebaTecnica.domain.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserProfileRepositoryImpl implements UserProfileRepository {
    private final UserProfileJpaRepository jpaRepository;

    @Override
    public Optional<UserProfile> findByUsername(String username) {
        return jpaRepository.findByNombreUsuario(username)
                .map(entity -> new UserProfile(
                        entity.getId(),
                        entity.getNombreUsuario(),
                        entity.getNombreCompleto(),
                        entity.getEmail(),
                        entity.getRepositoriosPublicos()
                ));
    }
}
