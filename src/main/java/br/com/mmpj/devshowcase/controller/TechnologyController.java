package br.com.mmpj.devshowcase.controller;

import br.com.mmpj.devshowcase.dto.TechnologyRequestDTO;
import br.com.mmpj.devshowcase.dto.TechnologyResponseDTO;
import br.com.mmpj.devshowcase.service.TechnologyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {

    @Autowired
    private TechnologyService technologyService;

    @PostMapping
    public ResponseEntity<TechnologyResponseDTO> createTechnology(@RequestBody @Valid TechnologyRequestDTO dto) {
        TechnologyResponseDTO saved = technologyService.createTechnology(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<TechnologyResponseDTO>> getAllTechnologies() {
        return ResponseEntity.ok(technologyService.getAllTechnologies());
    }
}