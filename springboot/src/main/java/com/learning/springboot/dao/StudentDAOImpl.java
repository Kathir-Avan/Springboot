package com.learning.springboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learning.springboot.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
public class StudentDAOImpl implements StudentDAO{

	public EntityManager entityManager;
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
		
	}
	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class,id);
	}
	@Override
	public List<Student> findAll() {
		TypedQuery<Student> theQuery = entityManager.createQuery("From Student",Student.class);
		return theQuery.getResultList();
	}
	@Override
	public List<Student> findByLastName(String ln) {
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lasttName=:theData",Student.class);
		theQuery.setParameter("theData", ln);
		return theQuery.getResultList();
	}
	@Override
	@Transactional
	public void update(Student student) {
		entityManager.merge(student);
	}
	@Override
	@Transactional
	public void delete(Integer id) {
		Student student = entityManager.find(Student.class, id);
		entityManager.remove(student);
	}
	@Override
	@Transactional
	public int deleteAll() {
		int deletedRows = entityManager.createQuery("DELETE FROM Student").executeUpdate();
		return deletedRows;
	}

}
