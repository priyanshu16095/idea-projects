package com.example.anotherAPI.service;

import com.example.anotherAPI.exception.StudentNotFoundException;
import com.example.anotherAPI.model.Student;
import com.example.anotherAPI.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudent(Long id) {
        if(studentRepository.findById(id).isEmpty()) {
            throw new StudentNotFoundException("Request student does not exist!");
        } else {
            return studentRepository.findById(id).get();
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public String createStudent(Student student) {
        studentRepository.save(student);
        return "Created";
    }

    @Override
    public String updateStudent(Student student) {
        studentRepository.save(student);
        return "Updated";
    }

    @Override
    public String deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return "Deleted";
    }
}
