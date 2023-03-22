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

    @Override
    @Transactional
    public void update(Object obj) {
        entityManager.merge(obj);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        entityManager.remove(findById(id));
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("delete from Student").executeUpdate();
    }

}
