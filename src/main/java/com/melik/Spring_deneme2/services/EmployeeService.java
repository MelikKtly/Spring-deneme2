package com.melik.Spring_deneme2.services;

import com.melik.Spring_deneme2.model.Employee;
import com.melik.Spring_deneme2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployeesList(){
        return employeeRepository.getAllEmployeesList();
    }

    public Employee getEmployeeById(String id){
        return employeeRepository.getEmployeeById(id);
    }

    public Employee getEmployeeByName(String name){
        return employeeRepository.getEmployeeByName(name);
    }

    public List<Employee> getAllEmployeeWithParams(String firstName,String lastName){
        return employeeRepository.getAllEmployeesListWithParams(firstName,lastName);

    }
}
