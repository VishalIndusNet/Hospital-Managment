package com.hospital.hospitalManagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;

import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//    @FutureOrPresent(message = "please put valid Date")
//    private String appointmentDate;

    @FutureOrPresent(message = "Please provide a valid date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate appointmentDate;


    @ManyToOne
    @JoinColumn(name= "doctor_id")
    private Doctor  doctor;
    @ManyToOne
    @JoinColumn(name= "patient_id")
    private Patient  patient;

}
