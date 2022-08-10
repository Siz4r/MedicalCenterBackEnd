package com.example.demo.Projects.projectParticipant;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/projectParticipant")
@AllArgsConstructor
public class ProjectParticipationController {
    private final ProjectParticipationService projectParticipationService;

    @PostMapping("/project/{projectId}/patient/{patientId}")
    public UUID addPatientToProject(@PathVariable("projectId") UUID projectId,
                                    @PathVariable("patientId") UUID patientId) {
        return projectParticipationService.addPatientToProject(patientId, projectId);
    }

    @DeleteMapping("/{projectParticipationId}")
    public void deletePatientFromProject(@PathVariable("projectParticipationId") UUID projectParticipationId) {
        projectParticipationService.deletePatientFromProject(projectParticipationId);
    }

    @PutMapping("/{projectParticipationId}")
    public void updatePatientConsent(@PathVariable("projectParticipationId") UUID projectParticipationId) {
        projectParticipationService.updatePatientConsent(projectParticipationId);
    }
}
