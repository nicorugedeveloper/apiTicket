package com.example.PruebaTecnica.infraestructura.persistencia.repositorio;

import com.example.PruebaTecnica.infraestructura.persistencia.entidad.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileJpaRepository extends JpaRepository<UserProfileEntity, Long> {
    Optional<UserProfileEntity> findByNombreUsuario(String nombreUsuario);
}
