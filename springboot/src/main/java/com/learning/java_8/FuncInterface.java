package com.learning.java_8;

@FunctionalInterface
public interface FuncInterface {

// Func.Interface can have only one abstract method and many static/default methods.
//public void rule(); 
//public void rule(int a, int b);
public int rule(int a, int b);


public static void rule_1() {
	System.out.println("Static method from interface used in utility functions");
}

default void calculateSalary(int salaryPerDay,int noOfDaysWorked) {
	System.out.println("From func interface "+salaryPerDay*noOfDaysWorked);
}
}
