package br.com.mmpj.devshowcase.repository;

import br.com.mmpj.devshowcase.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}