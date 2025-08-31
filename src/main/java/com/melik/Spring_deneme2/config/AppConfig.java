package com.melik.Spring_deneme2.config;

import com.melik.Spring_deneme2.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<Employee> EmployeesList(){
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("1","Melik","Atilla"));
        employeeList.add(new Employee("2","Ali","Utku"));
        employeeList.add(new Employee("3","Umut","Gök"));
        employeeList.add(new Employee("4","Melih","Ercan"));
        employeeList.add(new Employee("5","Mami","Yakmaz"));
        return employeeList;

    }
}
