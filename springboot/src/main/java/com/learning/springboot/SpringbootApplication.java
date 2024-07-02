package com.learning.springboot;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.learning.java_8.DefaultMethodInterfaceImplementation;
import com.learning.java_8.FuncInterface;
import com.learning.java_8.StreamAPILearning;
import com.learning.springboot.dao.StudentDAO;
import com.learning.springboot.entity.Student;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
		
//		StreamAPILearning.java8Learning();
		StreamAPILearning.Stream();
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO ) {
		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudent(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			findStudentByLastname(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.println("Deleted rows - "+studentDAO.deleteAll());
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		Student student = studentDAO.findById(studentId);
		student.setFirstName("Kathiravan");
		studentDAO.update(student);
	}

	private void findStudentByLastname(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findByLastName("avan");
		for(Student s : studentList) {
			System.out.println(s.toString());
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findAll();
		
		for(Student s : studentList) {
			System.out.println(s.toString());
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		
		Student s1 =  studentDAO.findById(5);
		System.out.println(s1.toString());
	}

	private void createStudent(StudentDAO studentDAO) {
		//create student
		Student tempStudent = new Student("Kathir","Avan","kathir@gmail.com");
		System.out.println("student created");
		//save
		studentDAO.save(tempStudent);
		System.out.println("student saved");
		//getid
		System.out.println("Student id is "+tempStudent.getId());
	}
	
	private void createMultipleStudent(StudentDAO studentDAO) {
		//create student
		Student s1 = new Student("Kathir","Avan","kathir@gmail.com");
		Student s2 = new Student("Priya","Karan","priya@gmail.com");
		Student s3 = new Student("Keerthi","Arjunan","keerthi@gmail.com");
		System.out.println("students created");
		//save
		studentDAO.save(s1);
		studentDAO.save(s2);
		studentDAO.save(s3);
		System.out.println("multiple student saved");
	}
}
