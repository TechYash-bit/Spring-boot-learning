package com.TechYash_bit.HospitalManagementSyatem.controller;

import com.TechYash_bit.HospitalManagementSyatem.dto.PatientDto;
import com.TechYash_bit.HospitalManagementSyatem.services.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/patient")
public class PatientController {

    private final Patient patient;

    PatientController(Patient patient){
        this.patient=patient;
    }
    @PostMapping(path = "/add")
    public ResponseEntity<PatientDto> addPatient(@RequestBody PatientDto patientDto){
        return new ResponseEntity<>(patient.addPatient(patientDto), HttpStatus.CREATED);
    }
}
