package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
