package com.tahiratakancan.config;

import com.tahiratakancan.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean //String Context içinde bir yer oluşturmak için yazdık.
    public List<Employee> employeeList(){
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("1","Atakan","Can"));
        employeeList.add(new Employee("2","Zehra","Can"));
        employeeList.add(new Employee("3","Alp","Can"));
        employeeList.add(new Employee("4","Ela","Can"));
        employeeList.add(new Employee("5","Aleyna","Can"));

        return employeeList;
    }
}
