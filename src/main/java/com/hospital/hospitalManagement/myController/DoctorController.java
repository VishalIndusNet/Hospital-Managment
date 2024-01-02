package com.hospital.hospitalManagement.myController;

import java.util.List;
import java.util.Optional;
import com.hospital.hospitalManagement.service.DoctorService;
import com.hospital.hospitalManagement.model.Doctor;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




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
	@GetMapping("/by-specialization")
	public ResponseEntity<List<Doctor>> getDoctorByspecialization(@RequestParam("specialization") String specialization){
		List<Doctor> doctors= doctorService.getDoctorBySpecialization(specialization);
		return ResponseEntity.ok(doctors);
	}

	@GetMapping("/doctors/present")
	public ResponseEntity<List<Doctor>> getDoctorsByPresent(@RequestParam("present") Boolean isPresent) {
		List<Doctor> doctors = doctorService.getDoctorsByPresent(isPresent);
		return ResponseEntity.ok(doctors);
	}

	@GetMapping("doctors/by-specialization-and-present")
	public ResponseEntity<List<Doctor>> getDoctorsBySpecializationAndPresent(
			@RequestParam String specialization,
			@RequestParam("present") Boolean isPresent){
		List<Doctor>  doctors = doctorService.getDoctorsBySpecializationAndPresent(specialization,isPresent);
		return ResponseEntity.ok(doctors);
	}

	@GetMapping("/doctors/by-specialization-and-present-page")
	public ResponseEntity<Page<Doctor>> getDoctorBySpecialization_present_page(
			@RequestParam String specialization,
			@RequestParam("present") Boolean isPresent,
			@RequestParam("page") int page,
			@RequestParam("size") int size){
		Page<Doctor> doctors = doctorService.getDoctorBySpecialization_Present_page(specialization, isPresent, page, size);
		return ResponseEntity.ok(doctors);
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