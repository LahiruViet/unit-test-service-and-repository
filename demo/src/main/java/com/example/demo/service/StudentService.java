package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    void addStudent(Student student);
    void deleteStudent(Long studentId);

}
