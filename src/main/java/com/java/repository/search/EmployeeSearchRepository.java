package com.java.repository.search;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.java.domain.Employee;

public interface EmployeeSearchRepository extends ElasticsearchRepository<Employee, Long> {

}
