package com.learning.springboot.restdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.restdemo.dao.EmployeeDAO;
import com.learning.springboot.restdemo.entity.Employee;
import com.learning.springboot.restdemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController{
	
	private EmployeeService employeeService;
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = 	employeeService;
	}
	
	@GetMapping("/employee")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employee/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		if(theEmployee == null){
			throw new RuntimeException("The employee id "+employeeId+" not found.");
		}
		return theEmployee;
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		Employee dbEmployee = employeeService.save(theEmployee);
		return dbEmployee;
	}
	
	@PutMapping("/employee/{theEmployee}")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		Employee dbEmployee = employeeService.save(theEmployee);
		return dbEmployee;
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		if(theEmployee == null){
			throw new RuntimeException("The employee id "+employeeId+" not found.");
		}
		employeeService.deleteById(employeeId);
		return "Deleted "+ employeeId;
		
	}
	
}
