package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private Student student;

	@Autowired
	private Person person;

	final String NAME = "Ram";
	final int ROLLNO = 21;
	final int AGE = 20;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		Doctor doctor = context.getBean(Doctor.class);
		doctor.assist();
		System.out.println(doctor.getQualification());
	}

	@Override
	public void run(String... args) throws Exception {
		this.student.setName(NAME);
		this.student.setRollno(ROLLNO);
		this.student.details();

		this.person.setName(NAME);
		this.person.setAge(AGE);
		this.person.details();
	}

}