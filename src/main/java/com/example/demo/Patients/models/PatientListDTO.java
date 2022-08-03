package com.example.demo.Patients.models;

import com.example.demo.Addresses.models.AddressListDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class PatientListDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String pesel;

    private AddressListDTO address;
}
