package patika.dev.week03.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import patika.dev.week03.models.Student;
import patika.dev.week03.service.Interface.IStudentService;

import java.util.List;

public class StudentController {

    IStudentService iStudentService;


    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudent() {
        return new ResponseEntity<>(iStudentService.findAll(), HttpStatus.OK);


    }

    @PostMapping("/students")
    public ResponseEntity<Student> saveStundent(@RequestBody Student student) {

        return new ResponseEntity<>((Student) iStudentService.save(student), HttpStatus.OK);


    }


}