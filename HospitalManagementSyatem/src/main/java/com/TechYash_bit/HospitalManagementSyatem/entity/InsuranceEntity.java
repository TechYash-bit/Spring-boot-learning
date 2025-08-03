package com.TechYash_bit.HospitalManagementSyatem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "insurance")
public class InsuranceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String policyNumber;
    private String provider;
    private LocalDate validityUntil;
    @CreatedDate
    private LocalDate createdAt;

    @OneToOne(mappedBy = "insurance")
    private PatientEntity patient;
}
