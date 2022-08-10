package com.example.demo.Researches;

import com.example.demo.Exceptions.IncorrectIdInputException;
import com.example.demo.Researches.models.Research;
import com.example.demo.Researches.models.ResearchCommand;
import com.example.demo.Researches.models.ResearchListDTO;
import com.example.demo.beans.idGenerator.IdGenerator;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ResearchService {
    private final IdGenerator idGenerator;
    private final ResearchRepository researchRepository;
    private final ModelMapper mapper;

    public UUID createResearch(ResearchCommand command) {
        return researchRepository.save(Research.builder()
                .orderResearches(new LinkedHashSet<>())
                .description(command.getWebInput().getDescription())
                .name(command.getWebInput().getName())
                .id(idGenerator.generateId())
                .build()).getId();
    }

    public Set<ResearchListDTO> getResearches() {
        return researchRepository.findAll().stream()
                .map(r -> mapper.map(r, ResearchListDTO.class))
                .collect(Collectors.toSet());
    }

    public void deleteById(ResearchCommand command) {
        researchRepository.deleteById(command.getId());
    }

    public void deleteAllByIds(ResearchCommand command) {
        researchRepository.deleteAllById(command.getIds());
    }

    public void updateResearch(ResearchCommand command) {
        var research = researchRepository.findById(command.getId()).orElseThrow(IncorrectIdInputException::new);

        research.setName(command.getWebInput().getName());
        research.setDescription(command.getWebInput().getDescription());

        researchRepository.save(research);
    }
}
