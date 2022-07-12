package controller;

import models.Course;
import models.Instructor;
import models.Student;
import service.CourseService;

import java.util.List;

public class CourseController {
    CourseService courseService = new CourseService();

    public List<Course> listAllCourse() {
        return courseService.listAll();
    }
    public Course findById(int id){
        return courseService.findById(id);
    }
    public void saveCourse(Course course){
        courseService.saveToDatabase(course);
    }
    public void updateCourse(Course course,int id) {
        courseService.updateOnDatabase(course, id);
    }
    public void deleteCourse(Course course) {
        courseService.deleteFromDatabase(course);
    }
    public void deleteCourse(int id) {
        courseService.deleteFromDatabase(id);
    }
    public void deleteCourseById(Long id) {
        courseService.deletebyCourseId(id);
    }
    public Instructor getCourseInsturctor(Course course) {
        return courseService.getInstructor(course);
    }
    public List<Student> getCourseStudentList(Course course) {
        return courseService.getStudentList(course);
    }
}
