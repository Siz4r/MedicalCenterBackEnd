package com.example.demo.Projects;

import com.example.demo.Projects.models.Project;
import com.example.demo.Projects.models.ProjectCommand;
import com.example.demo.Projects.models.ProjectListDTO;
import com.example.demo.Projects.models.ProjectWebInput;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/projects")
@AllArgsConstructor
public class ProjectsController {
    private final ProjectService projectService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProjectListDTO> getProjects() {
        return projectService.getProjects();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UUID addProject(@Valid @RequestBody ProjectWebInput webInput) {
        return projectService.createProject(ProjectCommand.builder()
                .webInput(webInput).build());
    }

    @PutMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "Resource updated successfully")
    public void updateProject(@Valid @RequestBody ProjectWebInput webInput, @PathVariable("id") UUID id) {
        projectService.updateProject(ProjectCommand.builder()
                .webInput(webInput)
                .id(id).build());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable("id") UUID id) {
        projectService.delete(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllProjects(@RequestBody List<UUID> ids) {
        projectService.deleteAll(ids);
    }
}
