package com.TechYash_bit.HospitalManagementSyatem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @CreatedDate
    private LocalDate createdAt;
    @OneToOne
    @JoinColumn(name = "doctorId",nullable = false)
    private DoctorEntity headOfDepartment;

    @ManyToMany
    @JoinColumn(name = "doctors")
    private List<DoctorEntity> doctors;


}
