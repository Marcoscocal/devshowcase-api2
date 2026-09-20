package br.com.mmpj.devshowcase.repository;

import br.com.mmpj.devshowcase.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}