package com.TechYash_bit.HospitalManagementSyatem.services;

import com.TechYash_bit.HospitalManagementSyatem.dto.PatientDto;
import com.TechYash_bit.HospitalManagementSyatem.entity.PatientEntity;
import com.TechYash_bit.HospitalManagementSyatem.repositories.PatientRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements Patient{
    private final PatientRepo patientRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<PatientDto> getAllpatient() {
        List<PatientEntity> patientEntities=patientRepo.findAll();
        return patientEntities
                .stream()
                .map(patientEntity -> modelMapper.map(patientEntity,PatientDto.class))
                .toList();
    }

    @Override
    public PatientDto addPatient(PatientDto patientDto) {
        PatientEntity patientEntity=modelMapper.map(patientDto,PatientEntity.class);
        return modelMapper.map(patientRepo.save(patientEntity),PatientDto.class);
    }
}
