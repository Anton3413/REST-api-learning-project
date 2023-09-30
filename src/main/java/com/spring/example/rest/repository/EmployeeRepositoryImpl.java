package com.spring.example.rest.repository;

import com.spring.example.rest.model.Employee;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

    @Autowired
    private SessionFactory factory;

    public List<Employee> getAllEmployees() {
       Query<Employee> query = factory.getCurrentSession().createQuery("from Employee ", Employee.class);
       return query.getResultList();
    }

    public void saveEmployee(Employee employee) {
        factory.getCurrentSession().saveOrUpdate(employee);
    }

   public Optional<Employee> getEmployeeById(int id) {
      Optional<Employee> employee =  Optional.ofNullable(factory.getCurrentSession().get(Employee.class,id));
      return employee;
    }

    public void deleteEmployeeById(int id) {
        Optional<Employee>  employee = getEmployeeById(id);
            factory.getCurrentSession().
            remove(employee.orElseThrow(
            ()->  new EntityNotFoundException("Its impossible to delete an employee with ID = "+ id)));

    }
}
