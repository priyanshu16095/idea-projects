package com.example.anotherAPI.controller;

import com.example.anotherAPI.model.Student;
import com.example.anotherAPI.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/student")
public class StudentController {

    StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }
    @GetMapping("")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public String createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return "Created";
    }

    @PutMapping
    public String updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return "Updated";
    }

    @DeleteMapping("{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "Deleted";
    }

}
