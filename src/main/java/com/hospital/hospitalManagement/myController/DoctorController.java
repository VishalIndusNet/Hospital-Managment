package com.hospital.hospitalManagement.myController;

import java.util.List;
import java.util.Optional;

import com.hospital.hospitalManagement.model.Doctor;
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

import com.hospital.hospitalManagement.service.DoctorService;


@RestController
@RequiredArgsConstructor
public class DoctorController {


	@Autowired
	private DoctorService doctorService;

	@GetMapping("/doctors")
	public List<Doctor> getAllDoctors() {

		return doctorService.getAllDoctors();
	}

	@GetMapping("/doctor/{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
		Optional<Doctor> doctor= doctorService.getDoctorById(id);
		return ResponseEntity.of(doctor);

	}

	@PostMapping("/doctor")
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctorDTO) {
		Doctor saveDoctor =doctorService.saveDoctor(doctorDTO);
		//  return new ResponseEntity<>(HttpStatus.CREATED);
		return  ResponseEntity.status(HttpStatus.CREATED).body(saveDoctor);
	}

	@PutMapping("/doctor/{id}")
	public ResponseEntity<Void> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctorDTO) {
		if (doctorService.getDoctorById(id) != null) {
			doctorDTO.setId(id);
			doctorService.saveDoctor(doctorDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("doctor/{id}")
	public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
		doctorService.deleteDoctor(id);
		return ResponseEntity.noContent().build();

	}

}
