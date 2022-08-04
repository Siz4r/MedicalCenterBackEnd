package com.example.demo.Patients;

import com.example.demo.Addresses.AddressRepository;
import com.example.demo.Addresses.models.Address;
import com.example.demo.Exceptions.IncorrectIdInputException;
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
    private final AddressRepository addressRepository;
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
        var address = modelMapper.map(command.getPatientWebInput().getAddressWebInput(), Address.class);

        address.setId(idGenerator.generateId());
        patient.setId(id);
        patient.setAddress(address);

        addressRepository.save(address);
        patientRepository.save(patient);

        return id;
    }

    public void updatePatient(PatientCommand command) {
        var patient = patientRepository.findById(command.getId()).orElseThrow(IncorrectIdInputException::new);
        var webInput = command.getPatientWebInput();
        var address = patient.getAddress();
        patient.setFirstName(webInput.getFirstName());
        patient.setLastName(webInput.getLastName());
        patient.setEmail(webInput.getEmail());
        patient.setPesel(webInput.getPesel());

        address.setCity(webInput.getAddressWebInput().getCity());
        address.setStreet(webInput.getAddressWebInput().getStreet());
        address.setBuildingNumber(webInput.getAddressWebInput().getBuildingNumber());
        address.setApartmentNumber(webInput.getAddressWebInput().getApartmentNumber());
        address.setPostalCode(webInput.getAddressWebInput().getPostalCode());

        patientRepository.save(patient);
    }

    public void deletePatient(UUID id) {
        patientRepository.deleteById(id);
    }

    public void deleteAllPatients(List<UUID> ids) {
        ids.forEach(patientRepository::deleteById);
    }
}
