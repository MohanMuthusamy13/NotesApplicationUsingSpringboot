package com.example.Notes_Application.service;

import com.example.Notes_Application.models.Employee;
import com.example.Notes_Application.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        throw new RuntimeException("Couldn't find employee for the given id " + id);
    }

    @Override
    public void updateEmployee(int id, Employee updatedEmployee) {
        Employee employeeTemp;
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employeeTemp = employee.get();
        }
        else {
            throw new RuntimeException("Couldn't find employee for the given id " + id);
        }
        employeeTemp.setName(updatedEmployee.getName());
        employeeTemp.setAge(updatedEmployee.getAge());
        employeeTemp.setLocation(updatedEmployee.getLocation());
        employeeTemp.setEmail(updatedEmployee.getEmail());
        employeeTemp.setDepartment(updatedEmployee.getDepartment());

        employeeRepository.save(employeeTemp);
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findEmployeesByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> findEmployeesByDepartment (String department) {
        return employeeRepository.findByDepartment((department));
    }

    @Override
    public List<Employee> findEmployeesByNameAndLocation(String name, String location) {
        return employeeRepository.findByNameAndLocation(name, location);
    }

    @Override
    public List<Employee> findEmployeesByNameContaining(String name) {
        return employeeRepository.findByNameContaining(name);
    }
}