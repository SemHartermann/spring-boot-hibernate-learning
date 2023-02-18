package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {

            System.out.println("Create 3 Student objects ...");

            Student tempStudentOne = new Student("John", "Doe", "john@gmail.com");
            Student tempStudentTwo = new Student("Mary", "Public", "mary@gmail.com");
            Student tempStudentThree = new Student("Sem", "Zhivotov", "semzhivotov@gmail.com");

            session.beginTransaction();

            System.out.println("Saving the student");
            session.save(tempStudentOne);
            session.save(tempStudentTwo);
            session.save(tempStudentThree);

            session.getTransaction().commit();

            System.out.println("Done!");

        }finally {
            session.close();
            factory.close();
        }

    }

}
