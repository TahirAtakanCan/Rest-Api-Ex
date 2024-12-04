package com.tahiratakancan.controller;


import com.tahiratakancan.model.Employee;
import com.tahiratakancan.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeController {

    @Autowired //Kullaranak Service context içindeki bean kısımlarını çekmiş oluyorum !! -> Ayrıca @Service anatosyonunu EmployeeService tarafında da yazmak gerekiyor.
    private EmployeeService employeeService;

    // Bu şekilde yazılmaması gerekir. Doğrusu RequestParam ile kullanımıdır.
    @GetMapping(path = "/list")
    public List<Employee> getAllEmployeeList(){

        //Controller katmanından Service katmanına geçiş yaptım.
        //employeeService.getAllEmployeeList();
        return employeeService.getAllEmployeeList();
    }


    @GetMapping(path = "/list/{id}")   // Id=5 olanı getir diyeceğim için bir GetMapping
    public Employee getEmployeeById(@PathVariable(name = "id", required = true) String id){
        return employeeService.getEmployeeById(id);
    }

    // Genellikle bu şekilde yazmak daha doğrudur.
    @GetMapping(path = "with-params")
    // RequestParam anatasyonunu kullanarak istediğim şekilde veriyi çekmeyi sağladım.
    public List<Employee> getEmployeeWithParams(@RequestParam(name = "firstName", required = false) String firstName, @RequestParam(name = "lastName", required = false) String lastName){
        return employeeService.getEmployeeWithParams(firstName, lastName);
    }

    @PostMapping(path = "save-employee")
    public Employee saveEmployee(@RequestBody Employee newEmployee) {

        return employeeService.saveEmployee(newEmployee);
    }

    @DeleteMapping(path = "/delete-employee/{id}")
    public boolean deleteEmployee(@PathVariable(name = "id") String id){

        return employeeService.deleteEmployee(id);
    }


}
