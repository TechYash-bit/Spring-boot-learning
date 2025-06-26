package com.TechYash_Bit.day2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day2Application implements CommandLineRunner {

	@Autowired
	DataBase ser;
	public static void main(String[] args) {
		SpringApplication.run(Day2Application.class, args);
		System.out.println("hello this is main static method");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(ser.getDB());
	}
}
