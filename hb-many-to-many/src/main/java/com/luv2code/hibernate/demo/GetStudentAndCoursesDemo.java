package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetStudentAndCoursesDemo {

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
            /*session.beginTransaction();

            Student tempStudent = session.get(Student.class, 1);

            System.out.println("Studewnt:" + tempStudent);
            System.out.println("Courses: " + tempStudent.getCourses());

            Course tempCourseOne = new Course("Dota-dota");
            Course tempCourseTwo = new Course("Lol - lol");

            tempCourseOne.addStudent(tempStudent);

            tempCourseTwo.addStudent(tempStudent);

            session.save(tempCourseOne);
            session.save(tempCourseTwo);

            // commit transaction
            session.getTransaction().commit();

            session.close();*/

            session.beginTransaction();

            System.out.println("Courses:" + session.get(Student.class, 1).getCourses());

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }

}
