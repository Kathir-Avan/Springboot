package com.learning.springboot.restdemo.dao;

import java.util.List;

import com.learning.springboot.restdemo.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();
	Employee findById(int theId);
	Employee save(Employee theEmployee);
	void deleteById(int theId);	

}
