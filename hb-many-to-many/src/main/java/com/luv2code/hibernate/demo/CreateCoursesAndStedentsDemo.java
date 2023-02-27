package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndStedentsDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {


            // start a transaction
            session.beginTransaction();

            Course tempCourseOne = new Course("Java-java");
            Course tempCourseTwo = new Course("Php-php");

            session.save(tempCourseOne);
            session.save(tempCourseTwo);

            System.out.println("Course1: " + tempCourseOne);
            System.out.println("Course2: " + tempCourseTwo);

            Student tempStudentOne = new Student("Sem","Zhivotov","semzhivotov@gmail.com");
            Student tempStudentTwo = new Student("Kostya","Titarenko","titarenko@gmail.com");

            tempCourseOne.addStudent(tempStudentOne)
                    .addStudent(tempStudentTwo);

            tempCourseTwo.addStudent(tempStudentOne)
                    .addStudent(tempStudentTwo);

            session.save(tempStudentOne);
            session.save(tempStudentTwo);

            System.out.println("Student1: " + tempStudentOne);
            System.out.println("Student2: " + tempStudentTwo);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }

}
