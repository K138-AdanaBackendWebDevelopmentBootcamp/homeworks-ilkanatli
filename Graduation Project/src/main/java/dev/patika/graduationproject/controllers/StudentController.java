package dev.patika.graduationproject.controllers;

import dev.patika.graduationproject.models.Student;
import dev.patika.graduationproject.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("students")
@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.save(student),HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.update(student),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        studentService.deleteById(id);
        return "Deleted...";
    }

    @GetMapping("/name")
    public ResponseEntity<Student> getStudentByName(@RequestParam String name) {
        Student student = studentService.findByName(name);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/name/{name}")
    public String deleteStudentByName(@PathVariable String name) {
        studentService.deleteByName(name);
        return "Deleted...";
    }
}
