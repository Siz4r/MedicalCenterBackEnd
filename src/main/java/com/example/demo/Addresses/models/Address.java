package com.example.demo.Addresses.models;

import com.example.demo.Patients.models.Patient;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
public class Address {
    @Id
    private UUID id;
    private String city;
    private String street;
    private String postalCode;
    private int buildingNumber;
    private int apartmentNumber;

    @OneToOne(mappedBy = "address")
    private Patient patient;

}
