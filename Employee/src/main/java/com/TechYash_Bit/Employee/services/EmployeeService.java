package com.TechYash_Bit.Employee.services;

import com.TechYash_Bit.Employee.dto.EmployeeDto;
import com.TechYash_Bit.Employee.repository.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

final private EmployeeRepo employeeRepo;
final private ModelMapper modelMapper;
EmployeeService(EmployeeRepo employeeRepo, ModelMapper modelMapper){
    this.employeeRepo=employeeRepo;
    this.modelMapper=modelMapper;

}

    public List<EmployeeDto> getAllAccount() {
        return
    }
}
