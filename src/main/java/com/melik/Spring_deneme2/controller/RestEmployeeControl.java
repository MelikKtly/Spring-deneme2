package com.melik.Spring_deneme2.controller;

import com.melik.Spring_deneme2.model.Employee;
import com.melik.Spring_deneme2.repository.EmployeeRepository;
import com.melik.Spring_deneme2.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/api")
public class RestEmployeeControl {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee-list")
    public List<Employee> getAllEmployeesList(){
        return employeeService.getAllEmployeesList();
    }

    // ID'ye göre çalışan getir
    @GetMapping("/employee-list/id/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    // İsme göre çalışan getir
    @GetMapping("/employee-list/name/{firstName}")
    public Employee getEmployeeByName(@PathVariable String firstName) {
        return employeeService.getEmployeeByName(firstName);
    }


}
