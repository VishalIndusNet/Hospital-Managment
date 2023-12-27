package com.hospital.hospitalManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.hospitalManagement.model.Appointment;

public interface AppoinmentRepo extends JpaRepository<Appointment, Long> {

}
