package com.java.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.domain.Department;
import com.java.service.DepartmentService;

@RestController
@RequestMapping(value = "/api")
public class DepartmentController {

	private final DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@PostMapping(value = "departments")
	public ResponseEntity<Department> save(@Valid @RequestBody Department department) {

		return departmentService.save(department);
	}

	@PutMapping(value = "departments")
	public ResponseEntity<Department> update(@Valid @RequestBody Department department) {

		return departmentService.save(department);
	}

	@GetMapping(value = "departments")
	public ResponseEntity<List<Department>> findAll(Pageable pageable) {

		return departmentService.findAll(pageable);
	}

	@GetMapping(value = "departments/{id}")
	public ResponseEntity<Department> finOne(@PathVariable Long id) {

		return departmentService.findOne(id);
	}
	
	@DeleteMapping(value = "departments/{id}")
	public void delete(@PathVariable Long id) {

		 departmentService.delete(id);
	}
	
	@GetMapping(value = "name/departments")
	public ResponseEntity<Department> findByDepartmentName(@RequestParam("name") String name) {

		return departmentService.findByName(name);
	}
	
	@GetMapping(value = "idname/departments")
	public ResponseEntity<Department> findByDepartmentName(@RequestParam Map<String, Object> queryParam) {

		return departmentService.findByIdAndName(queryParam);
	}

}
