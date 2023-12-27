package com.hospital.hospitalManagement.model;

import jakarta.persistence.*;
import lombok.Data;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String appointmentDate;
    @ManyToOne
    @JoinColumn(name= "doctor_id")
    private Doctor  doctor;
    @ManyToOne
    @JoinColumn(name= "patient_id")
    private Patient  patient;

}
