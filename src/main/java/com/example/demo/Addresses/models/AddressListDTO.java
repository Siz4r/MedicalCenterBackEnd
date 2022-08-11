package com.example.demo.Addresses.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddressListDTO {
    private String ccity;
    private String street;
    private String postalCode;
    private int buildingNumber;
    private int apartmentNumber;
}
