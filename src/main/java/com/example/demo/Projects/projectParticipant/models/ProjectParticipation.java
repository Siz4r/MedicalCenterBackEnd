package com.example.demo.projectParticipant.models;

import com.example.demo.Patients.models.Patient;
import com.example.demo.Projects.models.Project;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class ProjectParticipation {
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JsonBackReference
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonBackReference
    private Project project;

    private boolean consentToParticipate;

    public void addPatient(Patient patient) {
        setPatient(patient);
        patient.addProjectParticipation(this);
    }

    public void addProject(Project project) {
        setProject(project);
        project.addProjectParticipation(this);
    }
}
