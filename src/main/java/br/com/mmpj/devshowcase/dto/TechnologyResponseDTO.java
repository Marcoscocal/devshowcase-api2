package br.com.mmpj.devshowcase.dto;

import br.com.mmpj.devshowcase.model.Technology;

public class TechnologyResponseDTO {
    private Long id;
    private String name;

    public TechnologyResponseDTO() {}

    public TechnologyResponseDTO(Technology technology) {
        this.id = technology.getId();
        this.name = technology.getName();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
