package com.TechYash_Bit.Employee.controller;

import com.TechYash_Bit.Employee.dto.EmployeeDto;
import com.TechYash_Bit.Employee.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
   final private EmployeeService employeeService;

   EmployeeController(EmployeeService employeeService){
       this.employeeService=employeeService;
   }

    @GetMapping(path = "/all")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        return ResponseEntity.ok(employeeService.getAllAccount()).build();
    }
}
