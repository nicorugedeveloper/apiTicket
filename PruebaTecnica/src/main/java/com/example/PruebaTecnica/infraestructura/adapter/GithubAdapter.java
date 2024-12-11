package com.example.PruebaTecnica.infraestructura.adapter;

import com.example.PruebaTecnica.aplicacion.dto.GitHubUserDTO;
import com.example.PruebaTecnica.dominio.modelo.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GithubAdapter {
    private final WebClient webClient;

    public List<GitHubUserDTO> searchUsers(String name) {
        GitHubSearchResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search/users")
                        .queryParam("q", name)
                        .build())
                .retrieve()
                .bodyToMono(GitHubSearchResponse.class)
                .block();

        if (response != null && response.getItems() != null) {
            return response.getItems().stream()
                    .map(item -> new GitHubUserDTO(
                            item.getLogin(),
                            item.getId(),
                            item.getNodeId(),
                            item.getAvatarUrl(),
                            item.getGravatarId(),
                            item.getUrl(),
                            item.getHtmlUrl(),
                            item.getFollowersUrl(),
                            item.getFollowingUrl(),
                            item.getGistsUrl(),
                            item.getStarredUrl(),
                            item.getSubscriptionsUrl(),
                            item.getOrganizationsUrl(),
                            item.getReposUrl(),
                            item.getEventsUrl(),
                            item.getReceivedEventsUrl(),
                            item.getType(),
                            item.isSiteAdmin(),
                            item.getScore()
                    ))
                    .toList();
        }
        return List.of();
    }

    private static class GitHubSearchResponse {
        private List<GitHubUserItem> items;

        public List<GitHubUserItem> getItems() { return items; }
        public void setItems(List<GitHubUserItem> items) { this.items = items; }
    }

    private static class GitHubUserItem {
        private String login;
        private Long id;
        private String nodeId;
        private String avatarUrl;
        private String gravatarId;
        private String url;
        private String htmlUrl;
        private String followersUrl;
        private String followingUrl;
        private String gistsUrl;
        private String starredUrl;
        private String subscriptionsUrl;
        private String organizationsUrl;
        private String reposUrl;
        private String eventsUrl;
        private String receivedEventsUrl;
        private String type;
        private boolean siteAdmin;
        private double score;

        // Getters y Setters para cada campo
        public String getLogin() { return login; }
        public void setLogin(String login) { this.login = login; }
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getNodeId() { return nodeId; }
        public void setNodeId(String nodeId) { this.nodeId = nodeId; }
        public String getAvatarUrl() { return avatarUrl; }
        public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }
        public String getGravatarId() { return gravatarId; }
        public void setGravatarId(String gravatarId) { this.gravatarId = gravatarId; }
        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }
        public String getHtmlUrl() { return htmlUrl; }
        public void setHtmlUrl(String htmlUrl) { this.htmlUrl = htmlUrl; }
        public String getFollowersUrl() { return followersUrl; }
        public void setFollowersUrl(String followersUrl) { this.followersUrl = followersUrl; }
        public String getFollowingUrl() { return followingUrl; }
        public void setFollowingUrl(String followingUrl) { this.followingUrl = followingUrl; }
        public String getGistsUrl() { return gistsUrl; }
        public void setGistsUrl(String gistsUrl) { this.gistsUrl = gistsUrl; }
        public String getStarredUrl() { return starredUrl; }
        public void setStarredUrl(String starredUrl) { this.starredUrl = starredUrl; }
        public String getSubscriptionsUrl() { return subscriptionsUrl; }
        public void setSubscriptionsUrl(String subscriptionsUrl) { this.subscriptionsUrl = subscriptionsUrl; }
        public String getOrganizationsUrl() { return organizationsUrl; }
        public void setOrganizationsUrl(String organizationsUrl) { this.organizationsUrl = organizationsUrl; }
        public String getReposUrl() { return reposUrl; }
        public void setReposUrl(String reposUrl) { this.reposUrl = reposUrl; }
        public String getEventsUrl() { return eventsUrl; }
        public void setEventsUrl(String eventsUrl) { this.eventsUrl = eventsUrl; }
        public String getReceivedEventsUrl() { return receivedEventsUrl; }
        public void setReceivedEventsUrl(String receivedEventsUrl) { this.receivedEventsUrl = receivedEventsUrl; }
        public String getType() { return type; }
        public void setType(String type) { this.type = type; }
        public boolean isSiteAdmin() { return siteAdmin; }
        public void setSiteAdmin(boolean siteAdmin) { this.siteAdmin = siteAdmin; }
        public double getScore() { return score; }
        public void setScore(double score) { this.score = score; }
    }
}
