package com.learning.springboot.restdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.learning.springboot.restdemo.entity.Employee;

@RepositoryRestResource(path="members") // This will change the endpoint name from "employees" to "members"
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
}
