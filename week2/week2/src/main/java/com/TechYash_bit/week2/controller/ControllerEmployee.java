package com.TechYash_bit.week2.controller;

import com.TechYash_bit.week2.dto.Employee;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/emp")
public class ControllerEmployee {
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return new Employee(
                id,
                "Yash Harne",
                "Development",
                "harneyash777@gmail.com",
                LocalDateTime.now()  // Current Date and Time
        );
    }

    @PostMapping("/emppost")
    public String getEmployeeDetails(@RequestBody Employee employee) {
        return employee.getEmail() + " - " + employee.getDepartment();
    }

}
