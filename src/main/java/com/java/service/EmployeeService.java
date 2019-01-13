package com.java.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.java.domain.Employee;

public interface EmployeeService {
	
	Employee save(Employee employee);;
	
	List<Employee> findAll(org.springframework.data.domain.Pageable pageable);
	
	Employee findByCode (String code, Pageable pageable);
	

}
