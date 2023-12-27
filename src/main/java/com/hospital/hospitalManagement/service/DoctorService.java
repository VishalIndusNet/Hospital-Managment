package com.hospital.hospitalManagement.service;


import java.util.List;
import java.util.Optional;


import com.hospital.hospitalManagement.model.Doctor;
import com.hospital.hospitalManagement.repo.DoctorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DoctorService {
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

    public void deleteDoctor(Long id) {
        doctorRepo.deleteById(id);
    }
}
	
	

