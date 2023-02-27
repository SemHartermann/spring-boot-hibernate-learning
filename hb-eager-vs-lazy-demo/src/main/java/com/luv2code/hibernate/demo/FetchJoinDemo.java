package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();

            int id = 1;

            session.beginTransaction();

            Query<Instructor> query =
                    session.createQuery("select i from Instructor i " +
                            "join fetch i.courses " +
                            "where i.id =:instructorId", Instructor.class)
                            .setParameter("instructorId", id);

            Instructor instructor = query.getSingleResult();

            System.out.println("Instructor: " + instructor);

            session.getTransaction().commit();

            session.close();

            System.out.println("Courses: " + instructor.getCourses());


        } finally {
            factory.close();
        }
    }
}
