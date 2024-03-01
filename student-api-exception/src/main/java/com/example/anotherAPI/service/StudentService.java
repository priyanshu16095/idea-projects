package com.example.anotherAPI.service;

import com.example.anotherAPI.model.Student;

import java.util.List;

public interface StudentService {
    public Student getStudent(Long id);
    public List<Student> getAllStudents();
    public String createStudent(Student student);
    public String updateStudent(Student student);
    public String deleteStudent(Long id);
}
