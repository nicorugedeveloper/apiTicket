package com.example.PruebaTecnica.aplicacion.controlador;

import com.example.PruebaTecnica.aplicacion.dto.GitHubUserDTO;
import com.example.PruebaTecnica.dominio.servicio.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-profiles")
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;

    @GetMapping
    public ResponseEntity<List<GitHubUserDTO>> searchUsersByName(@RequestParam String name) {
        List<GitHubUserDTO> users = userProfileService.searchUsersByName(name);
        return ResponseEntity.ok(users);
    }
}
