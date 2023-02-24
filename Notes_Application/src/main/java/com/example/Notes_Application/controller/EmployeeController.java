package com.example.Notes_Application.controller;


import com.example.Notes_Application.models.Employee;
import com.example.Notes_Application.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Value("${app.name}")
    private String appName;

    @Value("${app.version : Version 1.0}")
    private String appVersion;

    @GetMapping("employees/nameAndVersion")
    private String getAppNameAndVersion() {
        return appName + "\n" + appVersion;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployee() {
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<HttpStatus> saveEmployee(@Valid @RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee
            (@PathVariable(value = "id") int id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/employee/delete")
    public ResponseEntity<HttpStatus> deleteEmployeeById(@RequestParam(value = "id") int id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/employees/getByName")
    public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam(value =  "name") String name) {
        return new ResponseEntity<>(employeeService.findEmployeesByName(name), HttpStatus.OK);
    }

    @GetMapping("/employees/getByDepartment")
    public ResponseEntity<List<Employee>> getEmployeesByDepartment
            (@RequestParam(value = "department") String department) {
        return new ResponseEntity<>(employeeService.findEmployeesByDepartment(department), HttpStatus.OK);
    }

    @GetMapping("/employees/getByNameAndLocation")
    public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation
            (@RequestParam String name, @RequestParam String location) {
        return new ResponseEntity<>(employeeService.findEmployeesByNameAndLocation(name, location), HttpStatus.OK);
    }

    @GetMapping("/employees/getByKeyword")
    public ResponseEntity<List<Employee>> getEmployeeByKeyword(@RequestParam(value = "keyword")String keyword) {
        return new ResponseEntity<>(employeeService.findEmployeesByNameContaining(keyword), HttpStatus.OK);
    }
 }