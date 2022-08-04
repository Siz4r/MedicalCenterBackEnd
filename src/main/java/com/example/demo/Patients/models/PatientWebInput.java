package com.example.demo.Patients.models;

import com.example.demo.Addresses.models.AddressWebInput;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
public class PatientWebInput {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    @NotBlank
    private String pesel;
    @Valid
    private AddressWebInput addressWebInput;
}
