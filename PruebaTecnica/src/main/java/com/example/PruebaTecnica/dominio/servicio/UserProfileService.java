package com.example.PruebaTecnica.dominio.servicio;

import com.example.PruebaTecnica.aplicacion.dto.GitHubUserDTO;
import com.example.PruebaTecnica.dominio.modelo.UserProfile;
import com.example.PruebaTecnica.dominio.repositorio.UserProfileRepository;
import com.example.PruebaTecnica.infraestructura.adapter.GithubAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final GithubAdapter githubAdapter;

    public List<GitHubUserDTO> searchUsersByName(String name) {
        return githubAdapter.searchUsers(name);
    }
}
