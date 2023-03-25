package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData() {

        students = new ArrayList<>();

        students.add(new Student("Sem", "Zhivotov", "semzhivotov@gmail.com"));
        students.add(new Student("Kostya", "Titarenko", "titarenko@gmail.com"));
        students.add(new Student("Egor", "Petrovich", "egorenko@gmail.com"));
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {

        if ((studentId >= students.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return students.get(studentId);
    }

}
