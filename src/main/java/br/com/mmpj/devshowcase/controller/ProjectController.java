package br.com.mmpj.devshowcase.controller;

import br.com.mmpj.devshowcase.dto.ProjectRequestDTO;
import br.com.mmpj.devshowcase.dto.ProjectResponseDTO;
import br.com.mmpj.devshowcase.dto.FeedbackRequestDTO;
import br.com.mmpj.devshowcase.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<Object> createProject(@RequestBody @Valid ProjectRequestDTO dto) {
        try {
            ProjectResponseDTO saved = projectService.createProject(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Page<ProjectResponseDTO>> getProjects(
            @RequestParam(required = false) String technology,
            Pageable pageable) {
        Page<ProjectResponseDTO> projects = projectService.getProjects(technology, pageable);
        return ResponseEntity.ok(projects);
    }

    @PostMapping("/{id}/feedbacks")
    public ResponseEntity<ProjectResponseDTO> addFeedback(
            @PathVariable Long id,
            @Valid @RequestBody FeedbackRequestDTO dto) {
        ProjectResponseDTO response = projectService.addFeedback(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}/upvote")
    public ResponseEntity<ProjectResponseDTO> upvoteProject(@PathVariable Long id) {
        ProjectResponseDTO response = projectService.upvoteProject(id);
        return ResponseEntity.ok(response);
    }
}