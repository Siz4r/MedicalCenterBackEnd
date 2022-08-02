package com.example.demo.Addresses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor @NoArgsConstructor
@Setter
public class Address {
    @Id
    private UUID id;
    private String city;
    private String street;
    private String postalCode;
    private int buildingNumber;
    private int apartmentNumber;
}
