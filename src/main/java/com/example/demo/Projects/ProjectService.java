package com.example.demo.Projects;

import com.example.demo.Exceptions.IncorrectIdInputException;
import com.example.demo.Projects.models.Project;
import com.example.demo.Projects.models.ProjectCommand;
import com.example.demo.Projects.models.ProjectListDTO;
import com.example.demo.beans.idGenerator.IdGenerator;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;
    private final IdGenerator idGenerator;

    public List<ProjectListDTO> getProjects() {
        return projectRepository.findAll().stream()
                .map(project -> modelMapper.map(project, ProjectListDTO.class))
                .collect(Collectors.toList());
    }

    public UUID createProject(ProjectCommand command) {
        var id = idGenerator.generateId();

        projectRepository.save(Project.builder()
                .name(command.webInput().name())
                .id(id)
                .participants(new LinkedHashSet<>()).build());

        return id;
    }

    public void updateProject(ProjectCommand command) {
        var project = projectRepository.findById(command.id()).orElseThrow(IncorrectIdInputException::new);
        project.setName(command.webInput().name());

        projectRepository.save(project);
    }

    public void deleteAll(List<UUID> ids) {
        projectRepository.deleteAllById(ids);
    }

    public void delete(UUID id) {
        projectRepository.deleteById(id);
    }
}
