package com.example.demo.Projects.models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class ProjectParticipantDTO {
    private UUID id;
    private boolean consentToParticipate;
    private String patientFirstName;
    private String patientLastName;
    private String patientEmail;
    private String patientId;
}
