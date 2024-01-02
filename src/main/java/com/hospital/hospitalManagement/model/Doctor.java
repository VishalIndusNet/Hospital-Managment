package com.hospital.hospitalManagement.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Doctor {

	  @Id
	  @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Character sex;
	private String specialization;

	@Column(name = "is_present")
	private  Boolean isPresent;
}

