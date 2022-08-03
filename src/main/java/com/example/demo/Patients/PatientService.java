package com.example.demo.Patients;

import com.example.demo.Addresses.Address;
import com.example.demo.Addresses.AddressService;
import com.example.demo.Patients.models.Patient;
import com.example.demo.Patients.models.PatientCommand;
import com.example.demo.Patients.models.PatientListDTO;
import com.example.demo.beans.idGenerator.IdGenerator;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final AddressService addressService;
    private final IdGenerator idGenerator;
    private final ModelMapper modelMapper;

    public List<PatientListDTO> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(p -> modelMapper.map(p, PatientListDTO.class))
                .collect(Collectors.toList());
    }

    public UUID addPatient(PatientCommand command) {
        var id = idGenerator.generateId();
        var patient = modelMapper.map(command.getPatientWebInput(), Patient.class);

        patient.setAddress(addressService.addAddress(command.getPatientWebInput().getAddressWebInput()));

        patient.setId(id);
        patientRepository.save(patient);

        return id;
    }
}
