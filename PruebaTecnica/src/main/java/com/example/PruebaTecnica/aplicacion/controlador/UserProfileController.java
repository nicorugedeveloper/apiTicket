package com.example.PruebaTecnica.aplicacion.controlador;

import com.example.PruebaTecnica.aplicacion.dto.GitHubDTO;
import com.example.PruebaTecnica.aplicacion.dto.GitHubUserDTO;
import com.example.PruebaTecnica.aplicacion.dto.UserProfileDTO;
import com.example.PruebaTecnica.dominio.modelo.UserProfile;
import com.example.PruebaTecnica.dominio.servicio.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-profiles")
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;

    @GetMapping("/search")
    public ResponseEntity<GitHubDTO> searchUsersByName(@RequestParam String name) {
        GitHubDTO users = userProfileService.searchUsersByName(name);
        return ResponseEntity.ok(users);
    }
}
