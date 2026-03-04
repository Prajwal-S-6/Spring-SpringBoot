package com.learnings.spring.mvc;

import org.springframework.data.crossstore.ChangeSetPersister;
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

    public Employee updateEmployee(Integer empId, Employee employee) {
        Employee existingEmployee = employeeDao.findById(empId).orElseThrow(RuntimeException::new);
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setName(employee.getName());
        return employeeDao.save(existingEmployee);
    }
}
