package br.com.mmpj.devshowcase.service;

import br.com.mmpj.devshowcase.dto.ProfileRequestDTO;
import br.com.mmpj.devshowcase.dto.ProfileResponseDTO;
import br.com.mmpj.devshowcase.model.Profile;
import br.com.mmpj.devshowcase.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public ProfileResponseDTO createProfile(ProfileRequestDTO dto) {
        Profile profile = new Profile();
        profile.setName(dto.getName());
        profile.setBio(dto.getBio());
        profile.setgithubUrl(dto.getGithubUrl());

        Profile saved = profileRepository.save(profile);
        return new ProfileResponseDTO(saved);
    }

    public Optional<ProfileResponseDTO> getProfileById(Long id) {
        return profileRepository.findById(id).map(ProfileResponseDTO::new);
    }
}
