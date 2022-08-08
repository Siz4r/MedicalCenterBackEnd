package com.example.demo.projectParticipant.models;

import com.example.demo.Patients.models.Patient;
import com.example.demo.Projects.models.Project;
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
public class ProjectParticipant {
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private boolean consentToParticipate;
}
