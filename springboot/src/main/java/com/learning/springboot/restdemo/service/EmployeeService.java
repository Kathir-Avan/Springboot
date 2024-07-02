package com.learning.springboot.restdemo.service;

import java.util.List;

import com.learning.springboot.restdemo.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	Employee findById(int theId);
	Employee save(Employee theEmployee);
	void deleteById(int theId);	

}
