package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        try(SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

            Session session = factory.getCurrentSession();){
            session.beginTransaction();

            List<Student> theStudents = session
                    .createQuery("from Student where lastName='Luck'" +
                            "or firstName='Sem'")
                    .getResultList();

            System.out.println("the Students: " + theStudents);

            theStudents = session
                    .createQuery("from Student where email LIKE '%@gmail.com'")
                    .getResultList();

            session.getTransaction().commit();

            System.out.println("the Students: " + theStudents);
        }finally {

        }


    }

    public static List<Student> showStudentList(Session session) {

        return session
                .createQuery("from Student")
                .getResultList();

    }

}
