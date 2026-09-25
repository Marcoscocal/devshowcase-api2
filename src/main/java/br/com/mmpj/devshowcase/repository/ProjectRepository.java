package br.com.mmpj.devshowcase.repository;

import br.com.mmpj.devshowcase.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    
    @Query("SELECT p FROM Project p JOIN p.technologies t WHERE LOWER(t.name) = LOWER(:techName)")
    Page<Project> findByTechnologyName(@Param("techName") String techName, Pageable pageable);
}