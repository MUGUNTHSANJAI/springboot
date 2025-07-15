package com.example.Springbootfirstproject.Repository;

import com.example.Springbootfirstproject.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    List<Employee> findByRoles_RoleName(String role);
}
