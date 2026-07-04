package com.example.Student;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApplication implements CommandLineRunner {

	@Autowired
	private StudRepository repository;

	public StudentApplication(StudRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Student s1 = new Student(101, "Poonam", 90, "IT");
		Student s2 = new Student(102, "Akarshita", 90, "IT");
		Student s3 = new Student(103, "Athiya", 90, "IT");

		repository.save(s1);
		repository.save(s2);
		repository.save(s3);

		System.out.println("Student saved successfully...");

		System.out.println("Deleting Student...");

		Optional<Student> temp = repository.findById(103);

		if (temp.isPresent()) {

			Student student = temp.get();

			repository.delete(student);

			System.out.println("Student Deleted Successfully...");
			System.out.println(student);

		}
	}
}
