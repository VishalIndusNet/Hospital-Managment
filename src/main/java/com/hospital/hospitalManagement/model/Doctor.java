package com.hospital.hospitalManagement.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Doctor {

	  @Id
	  @GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String specialization;

}

