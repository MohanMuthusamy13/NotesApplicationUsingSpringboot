package com.example.Notes_Application.repository;

import com.example.Notes_Application.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByName(String name);

    List<Employee> findByDepartment(String department);

    List<Employee> findByNameAndLocation(String name, String location);

    List<Employee> findByNameContaining(String name);

}