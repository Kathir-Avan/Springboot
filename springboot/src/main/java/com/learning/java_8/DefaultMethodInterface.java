package com.learning.java_8;

public interface DefaultMethodInterface {
	
	default void calculateSalary(int salaryPerDay,int noOfDaysWorked) {
		System.out.println("From norm interface "+salaryPerDay*noOfDaysWorked);
	}

}