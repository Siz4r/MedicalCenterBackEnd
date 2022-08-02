package com.example.demo.Patients.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class PatientCommand {
    private PatientWebInput patientWebInput;
}
