package br.com.mmpj.devshowcase.service;

import br.com.mmpj.devshowcase.dto.TechnologyRequestDTO;
import br.com.mmpj.devshowcase.dto.TechnologyResponseDTO;
import br.com.mmpj.devshowcase.model.Technology;
import br.com.mmpj.devshowcase.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyService {

    @Autowired
    private TechnologyRepository technologyRepository;

    public TechnologyResponseDTO createTechnology(TechnologyRequestDTO dto) {
        Technology tech = new Technology();
        tech.setName(dto.getName());

        Technology saved = technologyRepository.save(tech);
        return new TechnologyResponseDTO(saved);
    }

    public List<TechnologyResponseDTO> getAllTechnologies() {
        return technologyRepository.findAll().stream()
                .map(TechnologyResponseDTO::new)
                .toList();
    }
}
