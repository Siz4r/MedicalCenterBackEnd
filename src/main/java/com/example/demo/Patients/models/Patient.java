package com.example.demo.Patients.models;

import com.example.demo.Addresses.Address;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
public class Patient {
    @Id
    private UUID id;

    private String firstName;
    private String lastName;

    private String pesel;
    private String email;

    @OneToOne
    private Address address;
}
