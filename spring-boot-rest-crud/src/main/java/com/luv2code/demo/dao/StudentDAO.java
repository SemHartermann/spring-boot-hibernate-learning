package com.luv2code.demo.dao;

import com.luv2code.demo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    void update(Object obj);

    void deleteById(int id);

    int deleteAll();

}
