package com.java.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.java.domain.Employee;
import com.java.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeResource {

	@Autowired
	EmployeeService employeeService;

	@PostMapping(value="/employee")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		Employee emp = employeeService.save(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);

	}

	@GetMapping(value ="/employee")
	@CrossOrigin(origins = "http://localhost:4200",  maxAge = 3600)
	public ResponseEntity<List<Employee>> findAll(Pageable pageable) {
		List<Employee> emp = employeeService.findAll(pageable);
		return new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);

	}
	
	@GetMapping(value ="/employee/{code}")
	@CrossOrigin(origins = "http://localhost:4200",  maxAge = 3600)
	public ResponseEntity<Employee> findByEmpCode(Pageable pageable, @PathVariable("code") String empCode) {
		Employee emp = employeeService.findByCode(empCode, pageable);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);

	}
	
	@PostMapping(value="/upload-file")
	@CrossOrigin(origins = "http://localhost:4200",  maxAge = 3600)
	public ResponseEntity<Void> uploadFile( @RequestPart("employee") Employee employee, @RequestPart("file") MultipartFile multipartFile) {
		multipartFile.getName();
		multipartFile.getOriginalFilename();
		System.out.println(multipartFile.getSize());
		return  new ResponseEntity<Void>(HttpStatus.OK);

	}
	
	/*@PostMapping(value="/upload-file")
	@CrossOrigin(origins = "http://localhost:4200",  maxAge = 3600)
	public ResponseEntity<Void> uploadFile( HttpServletRequest httpServletRequest) {
		//multipartFile.getName();
		//System.out.println(multipartFile.getSize());
		return  new ResponseEntity<Void>(HttpStatus.OK);

	}*/


}
