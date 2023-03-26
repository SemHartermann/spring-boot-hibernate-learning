package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        return entityManager.createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    public Employee findById(int id) {

        Employee employee = entityManager.find(Employee.class, id);

        return employee;

    }

    @Override
    public Employee save(Employee employee) {

        Employee dbEmployee = entityManager.merge(employee);

        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {

        Employee employee = entityManager.find(Employee.class, id);

        entityManager.remove(employee);

    }

}
