package com.hospital.hospitalManagement.repo;

import com.hospital.hospitalManagement.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepo extends JpaRepository<Medicine,Long> {


}
