package com.hospital.hospitalManagement.myController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospitalManagement.model.Patient;
import com.hospital.hospitalManagement.service.PatientService;

@RestController

public class PatientController {

	@Autowired
	private PatientService patientService;

	@GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Optional<Patient> patient= patientService.getPatientById(id);
        return ResponseEntity.of(patient);
    }

    @PostMapping("/patient")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        Patient savePatient =patientService.savePatient(patient);
       // return  new ResponseEntity<>(HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(savePatient);
    }

    @PutMapping("/patient/{id}")
    public ResponseEntity<Void> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        if (patientService.getPatientById(id) != null) {
            patient.setId(id);
            patientService.savePatient(patient);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/patient/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }


}
