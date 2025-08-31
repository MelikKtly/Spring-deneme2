package com.melik.Spring_deneme2.controller;

import com.melik.Spring_deneme2.model.Employee;
import com.melik.Spring_deneme2.repository.EmployeeRepository;
import com.melik.Spring_deneme2.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeControl {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public List<Employee> getAllEmployeesList(){
        return employeeService.getAllEmployeesList();
    }

    @GetMapping("/list/id/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/list/name/{firstName}")
    public Employee getEmployeeByName(@PathVariable String firstName) {
        return employeeService.getEmployeeByName(firstName);
    }

    @GetMapping(path = "/with-params")
    public List<Employee> getAllEmployeeWithParams(@RequestParam(name="firstName",required = false)String firstName,
                                                   @RequestParam(name="lastName",required = false)String lastName){
        return employeeService.getAllEmployeeWithParams(firstName,lastName);
    }


    @PostMapping(path = "/save-employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping(path = "/delete-employee/{id}")
    public boolean deleteEmployee(@PathVariable(name = "id") String id) {
        return employeeService.deleteEmployee(id);
    }

}
