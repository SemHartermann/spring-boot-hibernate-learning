package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {


            // start a transaction
            session.beginTransaction();

            Instructor tempInstructor = session.get(Instructor.class, 1);

            System.out.println("luv2code:" + tempInstructor);

            // commit transaction
            session.getTransaction().commit();

            session.close();

            System.out.println("luv2code Courses:"+tempInstructor.getCourses());

            System.out.println("luv2code: Done!");
        } finally {
            factory.close();
        }
    }

}
