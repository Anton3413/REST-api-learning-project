package com.spring.example.rest.controller;

import com.spring.example.rest.model.Employee;
import com.spring.example.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
