package com.java.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.domain.Department;
import com.java.repository.DepartmentRepositoryImpl;
import com.java.repository.search.DepartmentSearchRepositoryImpl;
import com.java.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentRepositoryImpl departmentRepository;

	private final DepartmentSearchRepositoryImpl departmentSearchRepository;

	public DepartmentServiceImpl(DepartmentRepositoryImpl departmentRepository,
			DepartmentSearchRepositoryImpl departmentSearchRepository) {
		this.departmentRepository = departmentRepository;
		this.departmentSearchRepository = departmentSearchRepository;
	}

	@Transactional
	@Override
	public ResponseEntity<List<Department>> findAll(Pageable pageable) {
		List<Department> departments = departmentSearchRepository.findAll(pageable).getContent();
		if (departments == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(departments);
	}

	@Transactional
	public ResponseEntity<Department> findOne(Long id) {

		Department department = departmentSearchRepository.findOne(id);
		if (department == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(department);
	}

	@Transactional
	public ResponseEntity<Department> save(Department department) {

		Department department2 = departmentRepository.save(department);
		departmentSearchRepository.save(department2);
		return ResponseEntity.ok().body(department2);
	}

	@Transactional
	public void delete(Long id) {

		departmentRepository.delete(id);
		departmentSearchRepository.delete(id);
		return;
	}

	@Override
	public ResponseEntity<Department> findByName(String name) {
		
		Department department=departmentSearchRepository.findByName(name);
		return ResponseEntity.ok().body(department);
	}
	
	@Override
	public ResponseEntity<Department> findByIdAndName(Map<String, Object> obj) {
		Long id=Long.parseLong(String.valueOf(obj.get("id")));
		String name=String.valueOf(obj.get("name"));
		Department department=departmentSearchRepository.findByIdAndName(id, name);
		return ResponseEntity.ok().body(department);
	}

}
