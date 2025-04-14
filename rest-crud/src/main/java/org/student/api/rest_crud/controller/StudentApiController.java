package org.student.api.rest_crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.student.api.rest_crud.entity.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentApiController {

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Sounak", "Saha"));
        studentList.add(new Student("Ankan", "Yadav"));
        studentList.add(new Student("Priyanka", "Ranjan"));

        return studentList;
    }
}
