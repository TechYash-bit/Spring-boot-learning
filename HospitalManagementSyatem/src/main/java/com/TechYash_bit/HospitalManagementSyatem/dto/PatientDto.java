package com.TechYash_bit.HospitalManagementSyatem.dto;

import com.TechYash_bit.HospitalManagementSyatem.entity.AppointmentEntity;
import com.TechYash_bit.HospitalManagementSyatem.entity.InsuranceEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class PatientDto {
private int id;
    private String name;
    private String gender;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNo;
    private String booldGroup;

    private LocalDateTime dateTime;


    private InsuranceEntity insurance;


    private List<AppointmentEntity> appointment;
}
