package org.student.api.rest_crud.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;
import org.student.api.rest_crud.entity.Student;
import org.student.api.rest_crud.exception.StudentNotFoundException;

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
        if (studentId < 0 || studentId >= studentList.size()) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return studentList.get(studentId);
    }

}
