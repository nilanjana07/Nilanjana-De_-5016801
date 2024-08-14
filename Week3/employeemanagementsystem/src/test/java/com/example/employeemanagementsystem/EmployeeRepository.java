package com.example.employeemanagementsystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentName(String departmentName);
List<Employee> findByNameContaining(String name);

@Query("SELECT e FROM Employee e WHERE e.email = ?1")
Employee findByEmail(String email);

}

