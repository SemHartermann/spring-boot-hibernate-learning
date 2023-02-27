package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

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



            /*session.beginTransaction();

            Course course = session.get(Course.class, 13);

            Student student = session.get(Student.class, 2);

            System.out.println("Students before:" + course.getStudents());

            session.delete(student);

            session.getTransaction().commit();

            session.close();*/

            session.beginTransaction();

            Course course = session.get(Course.class, 13);

            System.out.println("Students after:" + course.getStudents());

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }

}
