package com.java.repository.search;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.java.domain.Department;

public interface DepartmentSearchRepositoryImpl extends ElasticsearchRepository<Department, Long> {

	public Department findByName(String name);
	
	public Department findByIdAndName(Long id, String name);

}
