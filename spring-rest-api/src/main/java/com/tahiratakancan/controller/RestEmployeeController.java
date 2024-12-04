package com.tahiratakancan.controller;


import com.tahiratakancan.model.Employee;
import com.tahiratakancan.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/api")
public class RestEmployeeController {

    @Autowired //Kullaranak Service context içindeki bean kısımlarını çekmiş oluyorum !! -> Ayrıca @Service anatosyonunu EmployeeService tarafında da yazmak gerekiyor.
    private EmployeeService employeeService;

    @GetMapping(path = "/employee-list")
    public List<Employee> getAllEmployeeList(){

        //Controller katmanından Service katmanına geçiş yaptım.
        //employeeService.getAllEmployeeList();
        return employeeService.getAllEmployeeList();
    }


    @GetMapping(path = "/employee-list/{id}")   // Id=5 olanı getir diyeceğim için bir GetMapping
    public Employee getEmployeeById(@PathVariable(name = "id", required = true) String id){
        return employeeService.getEmployeeById(id);
    }

}
