package com.tahiratakancan.controller;


import com.tahiratakancan.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/api")
public class RestEmployeeController {

    @GetMapping(path = "/employee-list")
    public List<Employee> getAllEmployeeList(){

        return null;
    }

}
