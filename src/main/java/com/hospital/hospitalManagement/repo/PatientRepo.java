package com.hospital.hospitalManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.hospitalManagement.model.Patient;

public interface PatientRepo  extends JpaRepository<Patient, Long> {


}
