package com.java.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Table(name="emp")
@Entity
@Document(indexName = "emp", type = "emp")
public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull
	@Column(name ="code", nullable= false)
	private String code;
	
	@NotNull
	@Column(name ="name", nullable= false)
	private String name;
	
	@NotNull
	@Column(name ="gender", nullable= false)
	private String gender;
	
	@NotNull
	@Column(name ="annual_salary", nullable= false)
	private Double annualSalary;
	
	@NotNull
	@Column(name ="dob", nullable= false)
	@Field(type= FieldType.Date)
	private LocalDate dob;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Double getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(Double annualSalary) {
		this.annualSalary = annualSalary;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public int hashCode() {
		
		return Objects.hashCode(getId());
	}

	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		else if(obj == null ) {
			return false;
		}
		else if(obj!=getClass()) {
			return false;
		}
		Employee other =(Employee) obj;
		
		return Objects.equals(other.getId(), getId() );
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", code=" + code + ", name=" + name + ", gender=" + gender + ", annualSalary="
				+ annualSalary + ", dob=" + dob + "]";
	}

}
