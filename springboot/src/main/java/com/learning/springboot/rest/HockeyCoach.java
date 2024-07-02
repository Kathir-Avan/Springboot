package com.learning.springboot.rest;

import org.springframework.stereotype.Component;

@Component
public class HockeyCoach implements Coach {
	
	public HockeyCoach() {
	System.out.println("In Constructor " + getClass().getSimpleName());
	}

	@Override
	public String doDailyExcercise() {
		return "hockey excercise done";
	}
	
}
