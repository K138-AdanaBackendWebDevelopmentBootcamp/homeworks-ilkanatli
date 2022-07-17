package com.proje.controller;

import com.proje.model.api.request.*;
import com.proje.model.api.response.InstructorResponse;
import com.proje.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("instructors")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public List<InstructorResponse> getInstructors() {
        return instructorService.findInstructors();
    }

    @GetMapping("/{id}")
    public InstructorResponse getInstructorById(@PathVariable Long id) {
        return instructorService.findInstructorById(id);
    }

    @PostMapping("/permanent-instructors")
    public ResponseEntity<InstructorResponse> createPermanentInstructor(@RequestBody PermanentInstructorCreateRequest request) {
        return new ResponseEntity<>(instructorService.createPermanentInstructor(request), HttpStatus.CREATED);
    }
    @PostMapping("/visiting-researchers")
    public ResponseEntity<InstructorResponse> createVisitingResearcher(@RequestBody VisitingResearcherCreateRequest request) {
        return new ResponseEntity<>(instructorService.createVisitingResearcher(request), HttpStatus.CREATED);
    }

    @PutMapping
    public InstructorResponse updateInstructor(@RequestBody InstructorUpdateRequest request) {
        return instructorService.update(request);
    }

    @DeleteMapping("/{id}")
    public void deleteInstructor(@PathVariable Long id) {
        instructorService.deleteById(id);
    }
}