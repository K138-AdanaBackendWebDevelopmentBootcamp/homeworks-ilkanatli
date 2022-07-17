package com.proje.controller;

import com.proje.model.api.request.StudentCreateRequest;
import com.proje.model.api.request.StudentUpdateRequest;
import com.proje.model.api.response.StudentResponse;
import com.proje.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentResponse> getStudents() {
        return studentService.findStudents();
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable Long id) {
        return studentService.findStudentById(id);
    }

    @PostMapping
    public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentCreateRequest request) {
        return new ResponseEntity<>(studentService.create(request), HttpStatus.CREATED);
    }

    @PutMapping
    public StudentResponse updateStudent(@RequestBody StudentUpdateRequest request) {
        return studentService.update(request);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteById(id);
    }
}