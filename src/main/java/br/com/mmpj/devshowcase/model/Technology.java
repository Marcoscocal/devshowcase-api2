package br.com.mmpj.devshowcase.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "technologies")
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Relacionamento N : N com Project
    @ManyToMany(mappedBy = "technologies")
    private List<Project> projects;

    public Technology() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Project> getProjects() { return projects; }
    public void setProjects(List<Project> projects) { this.projects = projects; }
}