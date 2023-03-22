package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.hibernate.engine.spi.SessionLazyDelegator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {


    private EntityManager entityManager;

    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {

        entityManager.persist(student);

    }

    @Override
    @Transactional
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public List<Student> findAll() {

        TypedQuery<Student> query= entityManager.createQuery("from Student", Student.class);

        return query.getResultList();
    }

    public static int resolve(int[] array, int arraySize) {
        for (int i = 1; i < arraySize-1; i++) {
            if (array[i-1]==0 && array[i+1]==0) return  i;
        }
        return -1;
    }
}
