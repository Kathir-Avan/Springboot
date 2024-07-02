package com.learning.springboot.restdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.springboot.restdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
}
