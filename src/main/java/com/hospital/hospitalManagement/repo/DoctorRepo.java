package com.hospital.hospitalManagement.repo;

import com.hospital.hospitalManagement.model.Doctor;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {

    List<Doctor> findBySpecialization(String s);


   List<Doctor> findByIsPresent(Boolean isPresent);

    List<Doctor> findBySpecializationAndIsPresent(String specialization, Boolean isPresent);

   Page<Doctor> findBySpecializationAndIsPresent(String specialization, Boolean isPresent, Pageable pageable);

}


