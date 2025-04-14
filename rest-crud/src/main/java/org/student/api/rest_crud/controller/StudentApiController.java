package org.student.api.rest_crud.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.student.api.rest_crud.entity.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentApiController {
    private List<Student> studentList;

    @PostConstruct
    public void loadData() {
        studentList = new ArrayList<>();
        studentList.add(new Student("Sounak", "Saha"));
        studentList.add(new Student("Ankan", "Yadav"));
        studentList.add(new Student("Priyanka", "Ranjan"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentList;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        return studentList.get(studentId);
    }
}
