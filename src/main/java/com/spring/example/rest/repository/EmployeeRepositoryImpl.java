package com.spring.example.rest.repository;

import com.spring.example.rest.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

    @Autowired
    private SessionFactory factory;

    public List<Employee> getAllEmployees() {
       Query<Employee> query = factory.getCurrentSession().createQuery("from Employee ", Employee.class);
       List<Employee> employees = query.getResultList();
       return employees;
    }

    public void saveEmployee(Employee employee) {
        factory.getCurrentSession().saveOrUpdate(employee);
    }

   public Employee getEmployeeById(int id) {
        Employee employee = factory.getCurrentSession().get(Employee.class,id);
        System.out.println(employee.getId());
        return  employee;
    }

    public void deleteEmployeeById(int id) {
        Session session = factory.getCurrentSession();
        Employee employee = session.get(Employee.class,id);
        session.remove(employee);
    }
}
