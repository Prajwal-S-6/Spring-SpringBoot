package com.learnings.spring.mvc;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("employee")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        Integer savedEmpId = employeeService.addEmployee(employee);
        return ResponseEntity.created(UriComponentsBuilder.fromUriString("/api/employee/{savedEmpId}").build(savedEmpId)).build();
    }

    @PutMapping("employee/{empId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("empId") Integer id, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
    }

    @PatchMapping("/employee")
    public ResponseEntity<Employee> updateSalary(@RequestParam("id") Integer id, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateSalary(id, employee));
    }

    @DeleteMapping("/employee")
    public ResponseEntity<Void> deleteEmployee(@RequestParam Integer id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> employeeNotFound() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee not found");
    }

}
