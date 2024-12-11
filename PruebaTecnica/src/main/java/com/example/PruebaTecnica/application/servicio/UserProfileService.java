package com.example.PruebaTecnica.application.servicio;

import com.example.PruebaTecnica.domain.dto.GitHubDTO;
import com.example.PruebaTecnica.infraestructure.adapter.GithubAdapter;
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
