package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursesDemo {

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



            session.beginTransaction();

            /*Course deletedCourse = session.get(Course.class, 16);

            System.out.println("Courses:" + deletedCourse);*/

            System.out.println("Before: " + session.get(Student.class, 1).getCourses());

            /*session.delete(deletedCourse);*/

            System.out.println("After: " + session.get(Student.class, 1).getCourses());

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }

}
