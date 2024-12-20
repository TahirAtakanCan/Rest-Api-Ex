package com.tahiratakancan.services;

import com.tahiratakancan.model.Employee;
import com.tahiratakancan.model.UpdateEmployeeRequest;
import com.tahiratakancan.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired //Service katmanından repository katmanına geçiş
    private EmployeeRepository employeeRepository;  // @Autowired enjtekte olmaz ise null hatası alırsınız.

    public List<Employee> getAllEmployeeList(){
        // 100'lerce satır kontrol yapacaksınız.
        //employeeRepository.getAllEmployeeList();
        return employeeRepository.getAllEmployeeList();
    }

    // Katman dögüsünde repository katmanından service katmanına geçişi sağladık.

    public Employee getEmployeeById(String id){
        return employeeRepository.getEmployeeById(id);
    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName){

        return employeeRepository.getEmployeeWithParams(firstName, lastName);
    }

    public Employee saveEmployee(Employee newEmployee){
        return employeeRepository.saveEmployee(newEmployee);
    }

    public boolean deleteEmployee(String id){
        return employeeRepository.deleteEmployee(id);
    }

    public Employee updateEmployee(String id, UpdateEmployeeRequest request){
        return employeeRepository.updateEmployee(id, request);
    }


}
