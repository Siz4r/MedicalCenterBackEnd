package com.example.demo.Patients.models;

import com.example.demo.Addresses.AddressWebInput;
import lombok.Getter;

@Getter
public class PatientWebInput {
    private String firstName;
    private String lastName;
    private String email;
    private String pesel;
    private AddressWebInput addressWebInput;
}
