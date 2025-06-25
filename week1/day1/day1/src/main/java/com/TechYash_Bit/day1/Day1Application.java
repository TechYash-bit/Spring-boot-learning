package com.TechYash_Bit.day1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;


@SpringBootApplication
public class Day1Application implements CommandLineRunner {

	@Autowired
	Apple obj;
	@Autowired
	Mango mango;
	@Autowired
	Cherry cherry;

	@Autowired
	Banana banana;
	public static void main(String[] args) {
		SpringApplication.run(Day1Application.class, args);
		System.out.println("Hello from main method!");
	}

	// This method is executed after the Spring Boot application starts
	//this is no static method
	@Override
	public void run(String... args) throws Exception {
		obj.eatApple("yash");
		obj.eatApple();
		mango.eatingMango();
		banana.eatBanana();
		cherry.eatcherry();

	}
}
