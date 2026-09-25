package br.com.mmpj.devshowcase.dto;

import br.com.mmpj.devshowcase.model.Profile;

public class ProfileResponseDTO {
    private Long id;
    private String name;
    private String bio;
    private String githubUrl;

    public ProfileResponseDTO() {}

    public ProfileResponseDTO(Profile profile) {
        this.id = profile.getId();
        this.name = profile.getName();
        this.bio = profile.getBio();
        this.githubUrl = profile.getgithubUrl();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
    public String getGithubUrl() { return githubUrl; }
    public void setGithubUrl(String githubUrl) { this.githubUrl = githubUrl; }
}
