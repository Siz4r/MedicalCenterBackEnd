package com.example.demo.Addresses.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class AddressWebInput {
    @NotBlank
    private String city;
    @NotBlank
    private String street;
    @NotBlank
    private String postalCode;
    @Range(min = 1, max = 1000)
    private int buildingNumber;
    @Range(min = 0, max = 1000)
    private int apartmentNumber = 0;
}
