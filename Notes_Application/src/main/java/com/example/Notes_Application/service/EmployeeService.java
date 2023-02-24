package com.example.Notes_Application.service;

import com.example.Notes_Application.models.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getEmployeeById(int id);
    List<Employee> getEmployees();
    void addEmployee(Employee employee);

    void updateEmployee(int id, Employee employee);
    void deleteEmployeeById(int id);
    List<Employee> findEmployeesByName(String name);

    List<Employee> findEmployeesByDepartment(String department);

    List<Employee> findEmployeesByNameAndLocation(String name, String location);

    List<Employee> findEmployeesByNameContaining(String name);

}