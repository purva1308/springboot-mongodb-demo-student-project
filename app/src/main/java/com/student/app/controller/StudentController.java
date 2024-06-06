package com.student.app.controller;

import com.student.app.entity.Student;
import com.student.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/above-90-in-maths")
    public ResponseEntity<List<String>> getStudentsAbove90InMaths() {
        List<Student> students = studentRepository.getStudentsAbove90InMaths();
        List<String> studentNames = students.stream().map(Student::getName).toList();
        return ResponseEntity.ok(studentNames);
    }

    @PostMapping("/insertStudent")
    public void insertStudent(@RequestBody Student student) {
        studentRepository.insertStudent(student);
    }
}
