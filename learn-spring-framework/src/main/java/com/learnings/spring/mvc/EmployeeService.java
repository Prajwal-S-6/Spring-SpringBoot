package com.learnings.spring.mvc;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    public Integer addEmployee(Employee employee) {
        Employee savedEmployee = employeeDao.save(employee);
        return savedEmployee.id;
    }
}
