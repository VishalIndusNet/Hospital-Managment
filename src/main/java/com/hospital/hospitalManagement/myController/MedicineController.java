package com.hospital.hospitalManagement.myController;

import com.hospital.hospitalManagement.model.Doctor;
import com.hospital.hospitalManagement.model.Medicine;
import com.hospital.hospitalManagement.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MedicineController {
    @Autowired
    private  final MedicineService medicineService;

    @GetMapping("/medicines")
    public List<Medicine> getAllMedicines(){
        return medicineService.getAllMedicines();
    }
    @GetMapping("/medicine/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable Long id){
        Optional<Medicine> medicine= medicineService.getMedicineById(id);
        return ResponseEntity.of(medicine);
    }
    @PostMapping("/medicine")
    public ResponseEntity<Medicine> addMedicine(@RequestBody Medicine medicine){
        Medicine savemedicine = medicineService.addMedicine(medicine);
        return  ResponseEntity.status(HttpStatus.CREATED).body(savemedicine);
    }

    @PutMapping("/medicine/{id}")
    public ResponseEntity<Void> updateMedicine(@PathVariable Long id, @RequestBody Medicine medicine) {
        if (medicineService.getMedicineById(id) != null) {
            medicine.setId(id);
            medicineService.addMedicine(medicine);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/medicine/{id}")
    public ResponseEntity<Void> deleteMedicine(@PathVariable Long id){
        medicineService.deleteMedicine(id);
        return ResponseEntity.noContent().build();
    }
}
