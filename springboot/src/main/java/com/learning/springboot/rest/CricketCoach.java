package com.learning.springboot.rest;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
	
	public CricketCoach() {
		System.out.println("In Constructor " + getClass().getSimpleName());
	}

	@Override
	public String doDailyExcercise() {
		return "cricket excercise done";
	}
	
}
