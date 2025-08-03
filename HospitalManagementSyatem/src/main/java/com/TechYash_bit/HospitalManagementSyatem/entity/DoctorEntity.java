package com.TechYash_bit.HospitalManagementSyatem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "doctor")
public class DoctorEntity {
    private int id;
    private String name;
    private String specification;
    private  String email;
    @CreatedDate
    private LocalDateTime joinAt;

    @OneToMany(mappedBy = "doctorId")
    private List<AppointmentEntity> appointment;

    @ManyToMany(mappedBy = "doctors")
    private List<DepartmentEntity> departments;
}
