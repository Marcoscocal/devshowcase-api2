package br.com.mmpj.devshowcase.controller;

import br.com.mmpj.devshowcase.dto.ProjectRequestDTO;
import br.com.mmpj.devshowcase.model.Profile;
import br.com.mmpj.devshowcase.model.Project;
import br.com.mmpj.devshowcase.model.Technology;
import br.com.mmpj.devshowcase.repository.ProfileRepository;
import br.com.mmpj.devshowcase.repository.ProjectRepository;
import br.com.mmpj.devshowcase.repository.TechnologyRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private TechnologyRepository technologyRepository;

    @PostMapping
    public ResponseEntity<Object> createProject(@RequestBody @Valid ProjectRequestDTO dto) {
        Profile profile = profileRepository.findById(dto.getProfileId()).orElse(null);
        if (profile == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Perfil não encontrado com o ID informado.");
        }

        List<Technology> technologies = technologyRepository.findAllById(dto.getTechnologyIds());

        Project project = new Project();
        project.setTitle(dto.getTitle());
        project.setDescription(dto.getDescription());
        project.setRepositoryUrl(dto.getRepositoryUrl());
        project.setProfile(profile);
        project.setTechnologies(technologies);

        Project saved = projectRepository.save(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return ResponseEntity.ok(projects);
    }
}