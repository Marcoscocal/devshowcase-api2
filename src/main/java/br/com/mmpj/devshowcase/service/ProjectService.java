package br.com.mmpj.devshowcase.service;

import br.com.mmpj.devshowcase.dto.ProjectRequestDTO;
import br.com.mmpj.devshowcase.dto.ProjectResponseDTO;
import br.com.mmpj.devshowcase.model.Profile;
import br.com.mmpj.devshowcase.model.Project;
import br.com.mmpj.devshowcase.model.Technology;
import br.com.mmpj.devshowcase.dto.FeedbackRequestDTO;
import br.com.mmpj.devshowcase.model.Feedback;
import br.com.mmpj.devshowcase.repository.ProfileRepository;
import br.com.mmpj.devshowcase.repository.ProjectRepository;
import br.com.mmpj.devshowcase.repository.TechnologyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private TechnologyRepository technologyRepository;

    public ProjectResponseDTO createProject(ProjectRequestDTO dto) {
        Profile profile = profileRepository.findById(dto.getProfileId()).orElse(null);
        if (profile == null) {
            throw new EntityNotFoundException("Perfil não encontrado com o ID informado.");
        }

        List<Technology> technologies = technologyRepository.findAllById(dto.getTechnologyIds());

        Project project = new Project();
        project.setTitle(dto.getTitle());
        project.setDescription(dto.getDescription());
        project.setRepositoryUrl(dto.getRepositoryUrl());
        project.setProfile(profile);
        project.setTechnologies(technologies);

        Project saved = projectRepository.save(project);
        return new ProjectResponseDTO(saved);
    }

    public Page<ProjectResponseDTO> getProjects(String technology, Pageable pageable) {
        Page<Project> projects;
        if (technology != null && !technology.isBlank()) {
            projects = projectRepository.findByTechnologyName(technology, pageable);
        } else {
            projects = projectRepository.findAll(pageable);
        }
        return projects.map(ProjectResponseDTO::new);
    }

    public ProjectResponseDTO addFeedback(Long projectId, FeedbackRequestDTO dto) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado com o ID: " + projectId));

        Feedback feedback = new Feedback();
        feedback.setAuthor(dto.getAuthor());
        feedback.setComment(dto.getComment());
        feedback.setRating(dto.getRating());
        feedback.setProject(project);

        project.getFeedbacks().add(feedback);

        // Recalcular média
        double average = project.getFeedbacks().stream()
                .mapToInt(Feedback::getRating)
                .average()
                .orElse(0.0);
        
        project.setAverageRating(Math.round(average * 10.0) / 10.0); // 1 casa decimal

        Project saved = projectRepository.save(project);
        return new ProjectResponseDTO(saved);
    }

    public ProjectResponseDTO upvoteProject(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado com o ID: " + projectId));

        project.setUpvotes(project.getUpvotes() + 1);
        Project saved = projectRepository.save(project);
        return new ProjectResponseDTO(saved);
    }
}
