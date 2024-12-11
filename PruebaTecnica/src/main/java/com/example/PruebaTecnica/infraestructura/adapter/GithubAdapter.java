package com.example.PruebaTecnica.infraestructura.adapter;

import com.example.PruebaTecnica.aplicacion.dto.GitHubDTO;
import com.example.PruebaTecnica.aplicacion.dto.GitHubUserDTO;
import com.example.PruebaTecnica.dominio.modelo.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GithubAdapter {
    private final WebClient webClient;

    public GitHubDTO searchUsers(String name) {
        try {
            GitHubDTO response = webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/search/users")
                            .queryParam("q", name)
                            .build())
                    .retrieve()
                    .bodyToMono(GitHubDTO.class)
                    .block();

            if (response != null && response.getItems() != null) {
                List<GitHubUserDTO> adjustedUsers = response.getItems().stream()
                        .map(user -> new GitHubUserDTO(
                                user.getLogin(),
                                user.getId(),
                                user.getNodeId(),
                                user.getAvatarUrl(),
                                user.getGravatarId(),
                                user.getUrl(),
                                user.getHtmlUrl(),
                                user.getFollowersUrl(),
                                user.getFollowingUrl(),
                                user.getGistsUrl(),
                                user.getStarredUrl(),
                                user.getSubscriptionsUrl(),
                                user.getOrganizationsUrl(),
                                user.getReposUrl(),
                                user.getEventsUrl(),
                                user.getReceivedEventsUrl(),
                                user.getType(),
                                user.isSiteAdmin(),
                                user.getScore()
                        ))
                        .toList();

                return new GitHubDTO(response.getTotalCount(), response.isIncompleteResults(), adjustedUsers);
            }

            return new GitHubDTO(0, false, Collections.emptyList());

        } catch (WebClientResponseException e) {
            System.err.println("Error en la API de GitHub: " + e.getMessage());
            return new GitHubDTO(0, false, Collections.emptyList());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            return new GitHubDTO(0, false, Collections.emptyList());
        }
    }



}
