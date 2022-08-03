package com.example.demo.Patients;

import com.example.demo.Patients.models.Patient;
import com.example.demo.Patients.models.PatientCommand;
import com.example.demo.Patients.models.PatientListDTO;
import com.example.demo.Patients.models.PatientWebInput;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/patients")
public class PatientController {
    private final PatientService patientService;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<PatientListDTO> getPatients() {
        return patientService.getAllPatients();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public UUID createPatient(@RequestBody @Valid PatientWebInput webInput) {
        return patientService.addPatient(PatientCommand.builder().patientWebInput(webInput).build());
    }

}
