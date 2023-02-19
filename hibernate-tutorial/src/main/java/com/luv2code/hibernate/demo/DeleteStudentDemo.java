package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {

            long studentId = 2;

            // get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);
            System.out.println("Get complete: " + myStudent);

            /*session.delete(myStudent);*/

            session
                    .createQuery("delete from Student where id = 2 ")
                    .executeUpdate();

            System.out.println(session
                    .createQuery("from Student ")
                    .getResultList());

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Doone!");

        } finally {
            session.close();
            factory.close();
        }

    }

}
