package com.hospital.hospitalManagement.myController;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
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

import com.hospital.hospitalManagement.model.Appointment;
import com.hospital.hospitalManagement.service.AppointmentService;
@RestController
@RequiredArgsConstructor
public class AppointmentController {

	@Autowired
    private AppointmentService appointmentService;

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/appointments/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        Optional<Appointment> appointment= appointmentService.getAppointmentById(id);
        return ResponseEntity.of(appointment);
    }

    @PostMapping("appointments")
    public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment) {
        Appointment saveAppointment =appointmentService.saveAppointment(appointment);
        return  ResponseEntity.status(HttpStatus.CREATED).body(saveAppointment);
    }

    @PutMapping("/appointments/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        if (appointmentService.getAppointmentById(id) != null) {
            appointment.setId(id);
            appointmentService.saveAppointment(appointment);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }


}
