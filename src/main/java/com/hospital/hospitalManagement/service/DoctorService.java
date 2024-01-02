package com.hospital.hospitalManagement.service;


import com.hospital.hospitalManagement.model.Doctor;
import com.hospital.hospitalManagement.repo.DoctorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class DoctorService {
    @Autowired
    private final DoctorRepo doctorRepo;

    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepo.findById(id);
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    public List<Doctor> getDoctorsByPresent(Boolean isPresent) {
        return doctorRepo.findByIsPresent(isPresent);
    }

    public List<Doctor> getDoctorBySpecialization(String specialization) {
        return doctorRepo.findBySpecialization(specialization);
    }

    public List<Doctor> getDoctorsBySpecializationAndPresent(String specialization, Boolean isPresent) {
        return doctorRepo.findBySpecializationAndIsPresent(specialization, isPresent);
    }

    public Page<Doctor> getDoctorBySpecialization_Present_page(String specialization, Boolean isPresent, int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return doctorRepo.findBySpecializationAndIsPresent(specialization, isPresent, pageable);
    }


    public void deleteDoctor(Long id) {
        doctorRepo.deleteById(id);
    }

}
	
	

