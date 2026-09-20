package br.com.mmpj.devshowcase.repository;

import br.com.mmpj.devshowcase.model.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
}