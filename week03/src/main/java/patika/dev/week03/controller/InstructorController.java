package patika.dev.week03.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import patika.dev.week03.models.Instructor;
import patika.dev.week03.service.Interface.IInstructorService;


import java.util.List;

public class InstructorController {

    IInstructorService iInstructorService;

    @GetMapping("/instructor")
    public ResponseEntity<List<Instructor>> getAllInstructor() {
        return new ResponseEntity<>(iInstructorService.findAll(), HttpStatus.OK);


    }

    @PostMapping("/instructor")
    public ResponseEntity<Instructor> saveInstructor(@RequestBody Instructor instructor) {

        return new ResponseEntity<>((Instructor) iInstructorService.save(instructor), HttpStatus.OK);


    }
}