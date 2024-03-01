package com.example.anotherAPI.repository;

import com.example.anotherAPI.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
