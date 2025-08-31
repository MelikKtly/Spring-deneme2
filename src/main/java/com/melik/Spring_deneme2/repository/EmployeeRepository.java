package com.melik.Spring_deneme2.repository;

import com.melik.Spring_deneme2.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private List<Employee> employeeList;

    public List<Employee> getAllEmployeesList(){
        return employeeList;
    }

    public Employee getEmployeeById(String id){
        Employee findEmployee = null;
        for (Employee employee : employeeList){
            if(employee.getId().equals(id)){
                findEmployee = employee;
                break;
            }
        }
        return findEmployee;
    }

    public Employee getEmployeeByName(String name){
        Employee findEmployee = null;
        for (Employee employee : employeeList){
            if (employee.getFirstName().equals(name)){
                findEmployee = employee;
            }

        }
        return findEmployee;
    }
}
