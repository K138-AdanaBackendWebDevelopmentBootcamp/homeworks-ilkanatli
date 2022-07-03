package controller;


import models.Course;
import models.Student;
import service.CourseService;

import java.util.List;

public class CourseController {
    private final CourseService courseService = new CourseService();

    public List<Course> findAll() {
        return courseService.findAll();
    }

    public Course findById(int id) {
        return courseService.findById(id);
    }

    public void saveToDatabase(Course course) {
        courseService.saveToDatabase(course);
    }

    public void deleteFromDatabase(Course course) {
        courseService.deleteFromDatabase(course);
    }

    public void deleteFromDatabase(int id) {
        courseService.deleteFromDatabase(id);
    }

    public void updateOnDatabase(Course course) {
        courseService.updateOnDatabase(course);
    }

    public List<Student> getCourseStudentList(Course course) {
        return courseService.getCourseStudentList(course);
    }

    public List<Course> findGreatCreditScore(int creditScore) {
        return courseService.findGreatCreditScore(creditScore);
    }

    public List<Course> findBetweenCreditScore(int minCreditScore, int maxCreditScore) {
        return courseService.findBetweenCreditScore(minCreditScore, maxCreditScore);
    }

    public List<Course> findOrderByCourseCreditScore() {
        return courseService.findOrderByCourseCreditScore();
    }
}