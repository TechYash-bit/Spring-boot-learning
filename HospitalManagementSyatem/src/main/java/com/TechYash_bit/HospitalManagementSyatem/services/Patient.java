package com.TechYash_bit.HospitalManagementSyatem.services;

import com.TechYash_bit.HospitalManagementSyatem.dto.PatientDto;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface Patient {
    List<PatientDto> getAllpatient();

    PatientDto addPatient(PatientDto patientDto);
}
