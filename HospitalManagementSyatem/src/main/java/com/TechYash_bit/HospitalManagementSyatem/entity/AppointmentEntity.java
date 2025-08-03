package com.TechYash_bit.HospitalManagementSyatem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointment")
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private LocalDateTime appointmentTime;
    private String reason;
    private String status;

    @ManyToOne
    @JoinColumn(name ="patientId",nullable = false )
    private PatientEntity patientId;

    @ManyToOne
    @JoinColumn(name = "doctorId",nullable = false)
    private DoctorEntity doctorId;


}
