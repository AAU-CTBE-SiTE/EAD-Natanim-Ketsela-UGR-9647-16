package com.site.student_management.controller;

import com.site.student_management.dto.StudentRequest;
import com.site.student_management.dto.StudentResponse;
import com.site.student_management.service.StudentService;

import jakarta.validation.Valid;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentResponse createStudent( @Valid @RequestBody StudentRequest request) {
        return studentService.saveStudent(request);
    }

    @GetMapping
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
    @GetMapping("/email/{email}")
    public StudentResponse getStudentByEmail(@PathVariable String email) {
        return studentService.getStudentByEmail(email);
    }

    @PutMapping("/{id}")
    public StudentResponse updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentRequest request) {

        return studentService.updateStudent(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}