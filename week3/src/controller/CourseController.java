package com.proje.controller;

import com.proje.model.api.request.AddStudentToCourseRequest;
import com.proje.model.api.response.CourseResponse;
import com.proje.model.api.response.StudentResponse;
import com.proje.model.api.request.CourseCreateRequest;
import com.proje.model.api.request.CourseUpdateRequest;
import com.proje.service.CourseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseResponse> getAllCourses(@RequestParam(required = false) boolean isOrdered) {
        if (isOrdered) {
            return courseService.findCoursesByOrderedCreditScore();
        }
        return courseService.findCourses();
    }

    @GetMapping("/{id}")
    public CourseResponse getCourseById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @PostMapping
    @ApiOperation(value = "New Course adding method")
    public ResponseEntity<CourseResponse> createCourse(@RequestBody CourseCreateRequest request) {
        return new ResponseEntity<>(courseService.create(request), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteCourseById(@PathVariable Long id) {
        courseService.deleteById(id);
    }

    @PutMapping
    public CourseResponse updateCourse(@RequestBody CourseUpdateRequest request) {
        return courseService.update(request);
    }

    @GetMapping("/{id}/students")
    public List<StudentResponse> getStudentsByCourseId(@PathVariable Long id) {
        return courseService.findStudentsByCourseId(id);
    }

    @PostMapping("/{id}/students")
    public void addStudentToCourse(@PathVariable Long id, @RequestBody AddStudentToCourseRequest request) {
        courseService.addStudentToCourse(id, request);
    }

    @DeleteMapping("/{id}/students/{studentId}")
    public void deleteStudentInCourse(@PathVariable Long id, @PathVariable Long studentId) {
        courseService.deleteStudentInCourse(id, studentId);
    }

    @GetMapping("/filter/great-credit-score")
    public List<CourseResponse> getCoursesByGreatCreditScore(@RequestParam int creditScore) {
        return courseService.findCoursesByGreatCreditScore(creditScore);
    }

    @GetMapping("/filter/between-credit-score")
    public List<CourseResponse> getCoursesByBetweenCreditScore(@RequestParam int minCreditScore,@RequestParam int maxCreditScore) {
        return courseService.findCoursesByBetweenCreditScore(minCreditScore,maxCreditScore);
    }
}