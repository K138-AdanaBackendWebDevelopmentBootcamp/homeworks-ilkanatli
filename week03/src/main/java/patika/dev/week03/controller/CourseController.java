package patika.dev.week03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import patika.dev.week03.models.Course;
import patika.dev.week03.service.Interface.ICourseService;

import java.util.List;


@RestController
public class CourseController {

    ICourseService iCourseService;

    @Autowired
    public CourseController( ICourseService iCourseService) {

        this.iCourseService = iCourseService;
    }

    //field injection
    //setter injection
    //constructor injection

    @GetMapping("/controller")
    public ResponseEntity<List<Course>> getAllCourse() {
        return new ResponseEntity<>(iCourseService.findAll(), HttpStatus.OK);


    }

    @PostMapping("/controller")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {

        return new ResponseEntity<>((Course) iCourseService.save(course), HttpStatus.OK);


    }
}