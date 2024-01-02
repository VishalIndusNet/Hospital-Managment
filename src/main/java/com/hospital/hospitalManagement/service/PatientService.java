package com.hospital.hospitalManagement.service;

import java.util.List;
import java.util.Optional;

import com.hospital.hospitalManagement.model.Patient;
import com.hospital.hospitalManagement.repo.PatientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PatientService {
    @Autowired
    private final PatientRepo patientRepo;

    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepo.findById(id);
    }

    public Patient savePatient(Patient patient) {
        return patientRepo.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepo.deleteById(id);
    }
}
