package com.learnings.spring.security;

import com.learnings.spring.mvc.EmployeeNotFoundException;
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
        Employee existingEmployee = employeeDao.findById(empId).orElseThrow(EmployeeNotFoundException::new);
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setName(employee.getName());
        return employeeDao.save(existingEmployee);
    }

    public Employee updateSalary(Integer id, Employee employee1) {
        Employee employee = employeeDao.findById(id).orElseThrow(EmployeeNotFoundException::new);
        employee.setSalary(employee1.getSalary());
        return employeeDao.save(employee);

    }

    public void deleteEmployeeById(Integer id) {
        Employee employee = employeeDao.findById(id).orElseThrow(EmployeeNotFoundException::new);
        employeeDao.delete(employee);
    }
}
