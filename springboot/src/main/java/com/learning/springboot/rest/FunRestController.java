package com.learning.springboot.rest;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	@Value("${coach.name}")
	private String coachName;
	@Value("${team.name}")
	private String teamName;
	
	private Coach myCoach;
	
	@Autowired
	public FunRestController(@Qualifier("cricketCoach") Coach myCoach) {
		this.myCoach = myCoach;
	}
	
	@GetMapping("/dailyworkouts")
	public String getDailyWorkouts() {
		return myCoach.doDailyExcercise();
	}
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World";
	}
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5Kms";
	}
	
	@GetMapping("/value")
	public String getValue() {
		return "Value "+coachName+" "+teamName;
	}

}
