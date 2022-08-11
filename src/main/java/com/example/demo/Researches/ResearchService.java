package com.example.demo.Researches;

import com.example.demo.Exceptions.IncorrectIdInputException;
import com.example.demo.Researches.models.Research;
import com.example.demo.Researches.models.ResearchCommand;
import com.example.demo.Researches.models.ResearchListDTO;
import com.example.demo.beans.idGenerator.IdGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ResearchService {
    private final IdGenerator idGenerator;
    private final ResearchRepository researchRepository;
    private final ModelMapper mapper;

    public UUID createResearch(ResearchCommand command) {
        try {
            return researchRepository.save(Research.builder()
                    .orderResearches(new LinkedHashSet<>())
                    .description(command.getWebInput().getDescription())
                    .name(command.getWebInput().getName())
                    .id(idGenerator.generateId())
                    .build()).getId();
        }catch (Exception e) {
            log.error("Exceptions thrown at creating research: ",e);
            throw e;
        }

    }

    public Set<ResearchListDTO> getResearches() {
        try {
            return researchRepository.findAll().stream()
                .map(r -> mapper.map(r, ResearchListDTO.class))
                .collect(Collectors.toSet());

        } catch (Exception e) {
            log.error("Exceptions thrown at getting researches: ",e);
            throw e;
        }
    }

    public void deleteById(ResearchCommand command) {
        try {
            researchRepository.deleteById(command.getId());
        } catch (Exception e) {
            log.error(e.getMessage(), e.fillInStackTrace());
        }
    }

    public void deleteAllByIds(ResearchCommand command) {
        try {
            researchRepository.deleteAllById(command.getIds());
        } catch (Exception e) {
            log.error("Exception was thrown while deleting researches: ", e);
        }
    }

    public void updateResearch(ResearchCommand command) {
        try {
            var research = researchRepository.findById(command.getId()).orElseThrow(IncorrectIdInputException::new);

            research.setName(command.getWebInput().getName());
            research.setDescription(command.getWebInput().getDescription());

            researchRepository.save(research);
        } catch (Exception e) {
            log.error("Exception was thrown while updating research: ", e);
        }
    }
}
