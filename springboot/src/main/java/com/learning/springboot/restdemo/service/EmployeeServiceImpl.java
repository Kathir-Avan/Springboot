package com.learning.springboot.restdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.springboot.restdemo.dao.EmployeeDAO;
import com.learning.springboot.restdemo.dao.EmployeeRepository;
import com.learning.springboot.restdemo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
//	private EmployeeDAO employeeDAO;
	private EmployeeRepository employeeRepository;
	@Autowired
	/*
	 * public EmployeeServiceImpl(EmployeeDAO employeeDAO) { this.employeeDAO =
	 * employeeDAO; }
	 */
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	/*
	 * @Override public List<Employee> findAll() { return employeeDAO.findAll(); }
	 * 
	 * @Override public Employee findById(int theId) { return
	 * employeeDAO.findById(theId); }
	 * 
	 * @Transactional
	 * 
	 * @Override public Employee save(Employee theEmployee) { return
	 * employeeDAO.save(theEmployee); }
	 * 
	 * @Transactional
	 * 
	 * @Override public void deleteById(int theId) { employeeDAO.deleteById(theId);
	 * }
	 */

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee = result.get();
		} else {
			throw new RuntimeException("Didn't find the employee id "+theId);
		}
		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		return employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
