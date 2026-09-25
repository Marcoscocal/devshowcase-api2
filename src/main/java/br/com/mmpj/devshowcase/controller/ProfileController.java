package br.com.mmpj.devshowcase.controller;

import br.com.mmpj.devshowcase.dto.ProfileRequestDTO;
import br.com.mmpj.devshowcase.dto.ProfileResponseDTO;
import br.com.mmpj.devshowcase.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping
    public ResponseEntity<ProfileResponseDTO> createProfile(@RequestBody @Valid ProfileRequestDTO dto) {
        ProfileResponseDTO saved = profileService.createProfile(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileResponseDTO> getProfileById(@PathVariable Long id) {
        return profileService.getProfileById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}