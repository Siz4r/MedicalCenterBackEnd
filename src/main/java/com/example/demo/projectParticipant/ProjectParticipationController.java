package com.example.demo.projectParticipant;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/projectParticipant/project/{projectId}/patient/{patientId}")
public class ProjectParticipantController {

    @PostMapping
    public void addPatientToProject(@PathVariable("projectId") UUID projectId,
                                    @PathVariable("patientId") UUID patientId) {

    }

    @DeleteMapping
    public void deletePatientFromProject(@PathVariable("projectId") UUID projectId,
                                         @PathVariable("patientId") UUID patientId) {

    }
}
