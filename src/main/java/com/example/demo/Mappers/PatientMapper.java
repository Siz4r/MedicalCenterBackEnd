package com.example.demo.Mappers;

import com.example.demo.Addresses.models.Address;
import com.example.demo.Addresses.models.AddressListDTO;
import com.example.demo.Patients.models.Patient;
import com.example.demo.Patients.models.PatientListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {
    PatientMapper INSTANCE = Mappers.getMapper( PatientMapper.class );
    PatientListDTO patientToListDTO(Patient patient);

    @Mapping(target = "ccity", source = "city")
    AddressListDTO addressToListDTO(Address address);
}
