package br.com.mmpj.devshowcase.dto;

import jakarta.validation.constraints.NotBlank;

public class ProfileRequestDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String name;

    private String bio;

    @NotBlank(message = "A URL do GitHub é obrigatória")
    private String githubUrl;

    // Getters e Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
    public String getGithubUrl() { return githubUrl; }
    public void setGithubUrl(String githubUrl) { this.githubUrl = githubUrl; }
}