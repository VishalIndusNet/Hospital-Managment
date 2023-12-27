package com.hospital.hospitalManagement.repo;

import com.hospital.hospitalManagement.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {

}


