package com.example.PruebaTecnica.application.ports.inbound;

import com.example.PruebaTecnica.domain.dto.GitHubDTO;
import com.example.PruebaTecnica.application.servicio.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
