package com.learnings.spring.security;

import com.learnings.spring.mvc.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.security.authorization.AuthorityAuthorizationManager.hasAnyAuthority;

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

    @Secured("ADMIN")
    @PostMapping("/employee")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        Integer savedEmpId = employeeService.addEmployee(employee);
        return ResponseEntity.created(UriComponentsBuilder.fromUriString("/api/employee/{savedEmpId}").build(savedEmpId)).build();
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @PutMapping("employee/{empId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("empId") Integer id, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
    }

    @PatchMapping("/employee")
    public ResponseEntity<Employee> updateSalary(@RequestParam("id") Integer id, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateSalary(id, employee));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("employee")
    public ResponseEntity<Void> deleteEmployee(@RequestParam Integer id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> employeeNotFound() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee not found");
    }

}
