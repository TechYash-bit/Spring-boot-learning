package com.TechYash_bit.HospitalManagementSyatem.repositories;

import com.TechYash_bit.HospitalManagementSyatem.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<PatientEntity,Integer> {
}
