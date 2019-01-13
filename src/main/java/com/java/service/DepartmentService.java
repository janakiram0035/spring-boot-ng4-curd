package com.java.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.java.domain.Department;

public interface DepartmentService {

	public ResponseEntity<List<Department>> findAll(Pageable pageable);

	public ResponseEntity<Department> findOne(Long id);

	public ResponseEntity<Department> save(Department department);
	
	public void delete(Long id);
	
	public ResponseEntity<Department> findByName(String name);
	
	public ResponseEntity<Department> findByIdAndName(Map<String, Object> obj);

}
