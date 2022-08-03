package com.example.demo.Patients.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@Builder
public class PatientCommand {
    private UUID id;
    private PatientWebInput patientWebInput;
}
