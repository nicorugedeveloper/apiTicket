package com.example.PruebaTecnica.aplicacion.controlador;

import com.example.PruebaTecnica.aplicacion.dto.UserProfileDTO;
import com.example.PruebaTecnica.dominio.modelo.UserProfile;
import com.example.PruebaTecnica.dominio.servicio.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/user-profiles")
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;

    @GetMapping("/{username}")
    public ResponseEntity<UserProfileDTO> getUserProfileByUsername(@PathVariable String username) {
        Optional<UserProfile> userProfile = userProfileService.getUserProfileByUsername(username);
        return userProfile.map(profile -> {
            UserProfileDTO dto = new UserProfileDTO(
                    profile.getId(),
                    profile.getNombreUsuario(),
                    profile.getNombreCompleto(),
                    profile.getEmail(),
                    profile.getRepositoriosPublicos()
            );
            return ResponseEntity.ok(dto);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
