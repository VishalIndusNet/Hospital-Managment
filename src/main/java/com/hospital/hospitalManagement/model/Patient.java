package com.hospital.hospitalManagement.model;

import jakarta.persistence.Id;
import lombok.Data;
//import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Character sex;
	private String contactName;
	private String admitDate;
	private String dischargeDate;

}
