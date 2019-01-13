package com.java.serviceImpl;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.java.domain.Employee;
import com.java.repository.EmployeeRepository;
import com.java.repository.search.EmployeeSearchRepository;
import com.java.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeSearchRepository employeeSearchRepository;

	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeSearchRepository employeeSearchRepository,
			EmployeeRepository employeeRepository) {
		this.employeeSearchRepository = employeeSearchRepository;
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll(org.springframework.data.domain.Pageable pageable) {
		return employeeSearchRepository.findAll(pageable).getContent();
	}

	@Override
	public Employee save(Employee employee) {
		Employee result = employeeRepository.save(employee);
		employeeSearchRepository.save(result);
		return result;
	}
	
	public Employee findByCode (String code, Pageable pageable) {
		String query = "code:"+code;
		List<Employee> empList = employeeSearchRepository.search(QueryBuilders.queryStringQuery(query), pageable).getContent();
		if(empList!=null && !empList.isEmpty()) {
			return empList.get(0);
		}
		return null;	
	}

}
