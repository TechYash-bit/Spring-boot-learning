package com.TechYash_bit.week2.dto;

import java.time.LocalDateTime;

public class Employee {

        private int id;
        private String name;
        private String department;
        private String email;
        private LocalDateTime createdAt;

        // Default constructor (important for Spring and Jackson)
        public Employee() {
        }

        // Parameterized constructor
        public Employee(int id, String name, String department, String email, LocalDateTime createdAt) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.email = email;
            this.createdAt = createdAt;
        }

        // Getters and Setters

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }
}
