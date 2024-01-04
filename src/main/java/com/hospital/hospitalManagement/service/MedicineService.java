package com.hospital.hospitalManagement.service;

import com.hospital.hospitalManagement.model.Medicine;
import com.hospital.hospitalManagement.repo.MedicineRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicineService {

    @Autowired
    private final MedicineRepo medicineRepo;

    public List<Medicine> getAllMedicines(){
        return medicineRepo.findAll();
    }
    public Optional<Medicine> getMedicineById(Long id){
        return medicineRepo.findById(id);
    }
    public  Medicine addMedicine (Medicine medicine){
        return medicineRepo.save(medicine);
    }
    public void deleteMedicine (Long id){
        medicineRepo.deleteById(id);
    }
}
