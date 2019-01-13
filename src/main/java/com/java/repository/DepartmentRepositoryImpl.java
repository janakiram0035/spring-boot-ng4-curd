package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.domain.Department;

public interface DepartmentRepositoryImpl extends JpaRepository<Department, Long>{

}
