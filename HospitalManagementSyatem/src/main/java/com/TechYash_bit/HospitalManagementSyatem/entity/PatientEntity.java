package com.TechYash_bit.HospitalManagementSyatem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patient")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String gender;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNo;
    private String booldGroup;
    @CreatedDate
    private LocalDateTime dateTime;

    @OneToOne
    @JoinColumn(name = "insurance_id")
    private InsuranceEntity insurance;

    @OneToMany(mappedBy = "patientId")
    private List<AppointmentEntity> appointment;

}
