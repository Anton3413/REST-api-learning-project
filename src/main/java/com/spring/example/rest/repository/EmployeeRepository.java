package com.spring.example.rest.repository;

import com.spring.example.rest.model.Employee ;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

   List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Optional<Employee> getEmployeeById(int id);

    void deleteEmployeeById(int id);
}
