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


    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "Resource updated successfully")
    public void updatePatient(@RequestBody @Valid PatientWebInput webInput, @PathVariable("id") UUID id) {
        patientService.updatePatient(PatientCommand.builder()
                .id(id)
                .patientWebInput(webInput).build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletePatient(@PathVariable("id") UUID id) {
        patientService.deletePatient(id);
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletePatient(@RequestBody List<UUID> ids) {
        patientService.deleteAllPatients(ids);
    }
}
