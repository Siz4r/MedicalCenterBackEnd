package com.example.demo.Patients.models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class ProjectParticipantDTO {
    private UUID id;
    private String patientFirstName;
    private String patientLastName;
    private String patientEmail;
}
