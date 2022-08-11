package com.example.demo.Projects;

import com.example.demo.Exceptions.IncorrectIdInputException;
import com.example.demo.Projects.models.Project;
import com.example.demo.Projects.models.ProjectCommand;
import com.example.demo.Projects.models.ProjectListDTO;
import com.example.demo.beans.idGenerator.IdGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;
    private final IdGenerator idGenerator;

    public List<ProjectListDTO> getProjects() {
        try {
            return projectRepository.findAll().stream()
                    .map(project -> modelMapper.map(project, ProjectListDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Exception was thrown while getting ProjectListDTO: ", e);
            throw e;
        }
    }

    public UUID createProject(ProjectCommand command) {
        try {
            var id = idGenerator.generateId();

            projectRepository.save(Project.builder()
                    .name(command.webInput().name())
                    .id(id)
                    .participants(new LinkedHashSet<>()).build());

            return id;
        } catch (Exception e) {
            log.error("Exception was thrown while creating project: ", e);
            throw e;
        }
    }

    public void updateProject(ProjectCommand command) {
        try {
            var project = projectRepository.findById(command.id()).orElseThrow(IncorrectIdInputException::new);
            project.setName(command.webInput().name());
            projectRepository.save(project);
        } catch (Exception e) {
            log.error("Exception was thrown while updating project: ", e);
            throw e;
        }
    }

    public void deleteAll(List<UUID> ids) {
        try {
            projectRepository.deleteAllById(ids);
        } catch (Exception e) {
            log.error("Exception was thrown while deleting projects: ", e);
            throw e;
        }
    }

    public void delete(UUID id) {
        try {
        projectRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Exception was thrown while deleting project by id: ", e);
            throw e;
        }
    }
}
