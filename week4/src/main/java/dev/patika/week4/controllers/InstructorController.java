package dev.patika.week4.controllers;

import dev.patika.week4.models.Instructor;
import dev.patika.week4.services.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("instructors")
@RestController
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorService instructorService;

    @GetMapping
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Instructor getinstructorById(@PathVariable Long id) {
        return instructorService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Instructor> saveInstructor(@RequestBody Instructor instructor) {
        return new ResponseEntity<>(instructorService.save(instructor),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Instructor> updateInstructor(@RequestBody Instructor instructor) {
        return new ResponseEntity<>(instructorService.update(instructor),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteInstructorById(@PathVariable Long id) {
        instructorService.deleteById(id);
        return "Deleted...";
    }

    @GetMapping("/name")
    public ResponseEntity<Instructor> getInstructorByName(@RequestParam String name) {
        Instructor instructor = instructorService.findByName(name);
        return new ResponseEntity<>(instructor, HttpStatus.OK);
    }

    @DeleteMapping("/name/{name}")
    public String deleteInstructorByName(@PathVariable String name) {
        instructorService.deleteByName(name);
        return "Deleted...";
    }

    @GetMapping("/topThreeSalaryInstructor")
    public ResponseEntity<List<Instructor>> getTopThreeSalaryInstructor(){
        return ResponseEntity.ok(instructorService.topThreeSalaryInstructor());
    }

}
