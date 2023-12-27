package com.hospital.hospitalManagement.service;

import java.util.List;
import java.util.Optional;

import com.hospital.hospitalManagement.model.Appointment;
import com.hospital.hospitalManagement.repo.AppoinmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppoinmentRepo appoinmentRepo;

    public List<Appointment> getAllAppointments() {

        return appoinmentRepo.findAll();
    }

    ;


    public Optional<Appointment> getAppointmentById(Long id) {
        return appoinmentRepo.findById(id);
    }

    public Appointment saveAppointment(Appointment appointment) {
        return appoinmentRepo.save(appointment);
    }

    public void deleteAppointment(Long id) {
        appoinmentRepo.deleteById(id);
    }

}
