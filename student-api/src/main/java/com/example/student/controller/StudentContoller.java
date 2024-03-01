package com.example.student.controller;

import com.example.student.model.Student;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentContoller {

    Student student;

    @GetMapping("{rollno}")
    public Student getStudentDetails(Long rollno) {
        return student;
    }

    @PostMapping
    public String createStudent(@RequestBody Student student) {
        this.student = student;
        return "Student Created Sucessfully!";
    }

    @PutMapping
    public String updateStudent(@RequestBody Student student) {
        this.student = student;
        return "Student Updated Sucessfully!";
    }

    @DeleteMapping("{id}")
    public String deleteStudnet(Long id) {
        this.student = null;
        return "Student Deleted Sucessfully!";
    }

}
