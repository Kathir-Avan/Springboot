package com.learning.springboot.restdemo;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learning.springboot.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/test")
public class DemoRestController {
	
	private List<Student> theStudents;
	@PostConstruct // loads data only once
	public void loadData() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student("Kathir","Avan","email"));
		theStudents.add(new Student("Priya","K","email"));
		theStudents.add(new Student("Keerthi","A","email"));
	}
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello kathir from REST api!";
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return theStudents;
	}
	
	@GetMapping("/students/{id}")
	public Student getStudentsById(@PathVariable int id) {
		
		if((id >= theStudents.size()) || (id < 0)){
			throw new StudentNotFoundException("Student not found for the given id - "+id);
		}
		return theStudents.get(id);
	}
	
}
