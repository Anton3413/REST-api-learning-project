package com.spring.example.rest.repository;

import com.spring.example.rest.model.Employee ;
import java.util.List;

public interface EmployeeRepository {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployeeById(int id);

    void deleteEmployeeById(int id);
}
