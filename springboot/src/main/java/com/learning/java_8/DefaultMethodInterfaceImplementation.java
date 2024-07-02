package com.learning.java_8;

import java.util.function.Predicate;

public class DefaultMethodInterfaceImplementation implements DefaultMethodInterface,FuncInterface {

	@Override
	public int rule(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//Default methods from both the interface with
	@Override
	public void calculateSalary(int salaryPerDay, int noOfDaysWorked) {
		DefaultMethodInterface.super.calculateSalary(salaryPerDay, noOfDaysWorked);
		FuncInterface.super.calculateSalary(salaryPerDay, noOfDaysWorked);
	}
	
	//Predicate will return boolean based on conditions.It's a func. interface with test()abstract method.
	public Predicate<Integer> predicateSeniorCitizen() {
		//Implementation for predicate
		Predicate<Integer> p = (age) -> age>60;
		return p;
	}
	
	public Predicate<Integer> predicateEvenNumbers(){
		Predicate<Integer> p = (num) -> num%2 == 0;
		return p;
	}
}
