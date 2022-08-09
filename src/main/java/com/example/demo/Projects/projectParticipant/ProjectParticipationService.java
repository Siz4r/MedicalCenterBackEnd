package com.example.demo.projectParticipant;

import com.example.demo.Exceptions.IncorrectIdInputException;
import com.example.demo.Patients.PatientRepository;
import com.example.demo.Projects.ProjectRepository;
import com.example.demo.beans.idGenerator.IdGenerator;
import com.example.demo.projectParticipant.models.ProjectParticipation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ProjectParticipationService {
    private final ProjectParticipationRepository projectParticipationRepository;
    private final IdGenerator idGenerator;
    private final PatientRepository patientRepository;
    private final ProjectRepository projectRepository;

    public UUID addPatientToProject(UUID patientId, UUID projectId) {
        var id = idGenerator.generateId();
        var project = projectRepository.findById(projectId).orElseThrow(IncorrectIdInputException::new);
        var patient = patientRepository.findById(patientId).orElseThrow(IncorrectIdInputException::new);

        var projectParticipation = ProjectParticipation.builder()
                .consentToParticipate(false)
                .id(id)
                .build();

        projectParticipation.addProject(project);
        projectParticipation.addPatient(patient);

        projectRepository.save(project);
        patientRepository.save(patient);

        return id;
    }


    public void deletePatientFromProject(UUID projectParticipationId) {
        projectParticipationRepository.deleteById(projectParticipationId);
    }

    public void updatePatientConsent(UUID projectParticipationId) {
        var projectParticipation = projectParticipationRepository.findById(projectParticipationId).orElseThrow(IncorrectIdInputException::new);

        projectParticipation.setConsentToParticipate(!projectParticipation.isConsentToParticipate());

        projectParticipationRepository.save(projectParticipation);
    }
}
