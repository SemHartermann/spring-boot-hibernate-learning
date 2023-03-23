package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
			/*createStudent(studentDAO);*/
			creteMultipleStudents(studentDAO);
			/*readStudent(studentDAO);*/
			/*queryForStudents(studentDAO);*/
		};
	}

	private void queryForStudents(StudentDAO studentDAO) {
		for (Student student : studentDAO.findAll()){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		System.out.println("Creating new student object...");
		Student student = new Student("Sem","Zhivotov", "semzhivotov@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(student);

		System.out.println("Saved student: " + student);

		System.out.println("Retrieve student with id: " + student.getId());
		Student retrievedStudent = studentDAO.findById(student.getId());

		System.out.println("Retrieved student: " + retrievedStudent);

	}

	private void creteMultipleStudents(StudentDAO studentDAO) {

		System.out.println("Creating 3 new student objects...");
		Student student1 = new Student("Enot1", "Petrushka1", "kefteme1@gmail.com");
		Student student2 = new Student("Enot1", "Petrushka2", "kefteme2@gmail.com");
		Student student3 = new Student("Enot2", "Petrushka3", "kefteme2@gmail.com");

		System.out.println("Saving the students...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

		System.out.println("Saved student: " + student1);
		System.out.println("Saved student: " + student2);
		System.out.println("Saved student: " + student3);

	}


	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student student = new Student("Enot", "Petrushka", "kefteme@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(student);

		System.out.println("Saved student: " + student);

	}


}
