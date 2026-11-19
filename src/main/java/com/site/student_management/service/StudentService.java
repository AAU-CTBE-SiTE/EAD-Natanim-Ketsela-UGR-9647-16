package com.site.student_management.service;

import com.site.student_management.dto.StudentRequest;
import com.site.student_management.dto.StudentResponse;
import com.site.student_management.model.Student;
import com.site.student_management.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private StudentResponse convertToResponse(Student student) {
        return new StudentResponse(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }

    public StudentResponse saveStudent(StudentRequest request) {

        Student student = new Student();

        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setDepartment(request.getDepartment());

        Student savedStudent = studentRepository.save(student);

        return convertToResponse(savedStudent);
    }

    public List<StudentResponse> getAllStudents() {

        return studentRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public StudentResponse getStudentById(Long id) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            return null;
        }

        return convertToResponse(student);
    }


    public StudentResponse updateStudent(Long id, StudentRequest request) {

        Student existingStudent = studentRepository.findById(id).orElse(null);

        if (existingStudent == null) {
            return null;
        }

        existingStudent.setFirstName(request.getFirstName());
        existingStudent.setLastName(request.getLastName());
        existingStudent.setEmail(request.getEmail());
        existingStudent.setDepartment(request.getDepartment());

        Student updatedStudent = studentRepository.save(existingStudent);

        return convertToResponse(updatedStudent);
    }

    public StudentResponse getStudentByEmail(String email) {

        Student student = studentRepository.findByEmail(email);

        if (student == null) {
            return null;
        }

        return convertToResponse(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}