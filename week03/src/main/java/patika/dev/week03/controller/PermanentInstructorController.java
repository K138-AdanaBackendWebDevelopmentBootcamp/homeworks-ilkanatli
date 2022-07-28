package patika.dev.week03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import patika.dev.week03.models.PermanentInstructor;
import patika.dev.week03.service.Interface.IInstructorService;

import java.util.List;

@RestController
public class PermanentInstructorController {

    IInstructorService iInstructorService;

    @Autowired
    public PermanentInstructorController(@Qualifier("permanentInstructorServiceImpl") IInstructorService iInstructorService) {
        this.iInstructorService = iInstructorService;
    }

    @GetMapping("/controller")
    public ResponseEntity<List<PermanentInstructor>> getAllCourse() {
        return new ResponseEntity<>(iInstructorService.findAll(), HttpStatus.OK);


    }

    @PostMapping("/controller")
    public ResponseEntity<PermanentInstructor> saveCourse(@RequestBody PermanentInstructor permanentInstructor) {

        return new ResponseEntity<>((PermanentInstructor) iInstructorService.save(permanentInstructor), HttpStatus.OK);


    }




}