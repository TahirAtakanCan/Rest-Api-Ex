package com.tahiratakancan.repository;

import com.tahiratakancan.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private List<Employee> employeeList;

    public List<Employee> getAllEmployeeList(){

        return employeeList;
    }

    // Kullanıcının id = 5 değeri olan kaydı getirmesi için aşağıdaki kodu yazdık.

    public Employee getEmployeeById(String id){
        Employee findEmployee = null;
        for (Employee employee : employeeList){
            if (id.equals(employee.getId())){
                findEmployee = employee;
                break;
            }
        }
        return findEmployee;
    }


    public List<Employee> getEmployeeWithParams(String firstName, String lastName){
        List<Employee> employeeWithParams = new ArrayList<>();

        if(firstName == null && lastName == null){
            return employeeList;
        }

        for(Employee employee : employeeList){
            if(firstName!=null && lastName!=null){
                if(employee.getFirstName().equalsIgnoreCase(firstName) && employee.getLastName().equalsIgnoreCase(lastName)){
                    employeeWithParams.add(employee);
                }
            }
            if(firstName == null && lastName != null){
                if(employee.getLastName().equalsIgnoreCase(lastName)){
                    employeeWithParams.add(employee);
                }
            }
            if(firstName!=null && lastName == null){
                if(employee.getFirstName().equalsIgnoreCase(firstName)){
                    employeeWithParams.add(employee);
                }
            }

        }
        return employeeWithParams;
    }

    //Post kullanarak yeni kullanıcı ekledim. Bu kullanıcıyı yine repo - service - controller sırasına göre son kullanıcıya ileteceğim
    public Employee saveEmployee(Employee newEmployee){
        employeeList.add(newEmployee);
        return newEmployee;
    }

    // Silme işlemi yaparken remove komutunu düzgün kullanmak önemli.
    public boolean deleteEmployee(String id){
        Employee deleteEmployee = null;
        for (Employee employee : employeeList){
            if(id.equals(employee.getId())) {
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


}
