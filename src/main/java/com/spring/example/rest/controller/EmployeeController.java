package com.spring.example.rest.controller;

import com.spring.example.rest.model.Employee;
import com.spring.example.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
       return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee showEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployeeById(id);

        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }
}
