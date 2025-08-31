package com.melik.Spring_deneme2.repository;

import com.melik.Spring_deneme2.model.Employee;
import com.melik.Spring_deneme2.model.UpdateEmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    public List<Employee> getAllEmployeesListWithParams(String firstName,String lastName){
            List<Employee> employeeListWithParams = new ArrayList<>();
            if (firstName == null && lastName == null){
                return employeeList;
            }
            for (Employee employee : employeeList){
                if (firstName!=null && lastName!=null){
                    if(employee.getFirstName().equalsIgnoreCase(firstName) &&  employee.getLastName().equalsIgnoreCase(lastName)){
                        employeeListWithParams.add(employee);
                    }
                }
                if (firstName!=null && lastName==null){
                    if(employee.getFirstName().equalsIgnoreCase(firstName)){
                        employeeListWithParams.add(employee);
                    }
            }
                if (firstName==null && lastName!=null){
                    if(employee.getLastName().equalsIgnoreCase(lastName)){
                        employeeListWithParams.add(employee);
                    }
                }
            }
            return employeeListWithParams;
    }

    public Employee saveEmployee(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    public boolean deleteEmployee(String id) {
        Employee deleteEmployee = null;
        for (Employee employee : employeeList){
            if (employee.getId().equals(id)){
            deleteEmployee = employee;
            break;
            }
        }
        if (deleteEmployee == null){
            return false;
        }
        employeeList.remove(deleteEmployee);
        return true;
    }


    private Employee findEmployeeById(String id){
        Employee findEmployee = null;
        for (Employee employee : employeeList){
            if (employee.getId().equals(id)){
                findEmployee = employee;
                break;
            }
        }
        return findEmployee;
    }


    public Employee updateEmployee(String id, UpdateEmployeeRequest Request) {
        Employee findEmployee = findEmployeeById(id);
        if (findEmployee != null){
            deleteEmployee(id);
            Employee updateEmployee = new Employee();
            updateEmployee.setId(id);
            updateEmployee.setFirstName(Request.getFirstName());
            updateEmployee.setLastName(Request.getLastName());
            employeeList.add(updateEmployee);
            return findEmployee;
        }
        else {
            return null;
        }



    }
}
