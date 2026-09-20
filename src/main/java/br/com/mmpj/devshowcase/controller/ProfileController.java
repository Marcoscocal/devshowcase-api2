package br.com.mmpj.devshowcase.controller;

import br.com.mmpj.devshowcase.dto.ProfileRequestDTO;
import br.com.mmpj.devshowcase.model.Profile;
import br.com.mmpj.devshowcase.repository.ProfileRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody @Valid ProfileRequestDTO dto) {
        Profile profile = new Profile();
        profile.setName(dto.getName());
        profile.setBio(dto.getBio());
        profile.setgithubUrl(dto.getGithubUrl());

        Profile saved = profileRepository.save(profile);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        return profileRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}