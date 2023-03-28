package com.luv2code.cruddemo.service;

import com.luv2code.cruddemo.dao.EmployeeRepository;
import com.luv2code.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepo;

    public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepo.findById(id);

        Employee employee = null;

        if (result.isPresent()) {
            employee = result.get();
        }else{
            throw new RuntimeException("Did not find  employee Id - " + id);
        }

        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepo.deleteById(id);
    }
}
