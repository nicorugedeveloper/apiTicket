package com.example.PruebaTecnica.dominio.servicio;

import com.example.PruebaTecnica.aplicacion.dto.GitHubDTO;
import com.example.PruebaTecnica.infraestructura.adapter.GithubAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final GithubAdapter githubAdapter;

    public GitHubDTO searchUsersByName(String name) {
        return githubAdapter.searchUsers(name);
    }
}
