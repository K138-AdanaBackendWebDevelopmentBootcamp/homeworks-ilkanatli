package controller;
import models.Course;
import models.Student;
import service.CourseService;

import java.util.List;

public class CourseController {
    private static CourseService courseService = new CourseService();

    public List<Course> findAllCourse() {
        return courseService.findAll();

    }

    public Course findCourseById(int id) {
        return courseService.findById(id);
    }

    public static void saveCourse(Course course) {
        courseService.saveDatabase(course);

    }

    public void deleteCourse(Course course) {

        courseService.deleteFromDatabase(course);

    }

    public void deleteCourse(int id) {

        courseService.deleteFromDatabase(id);
    }

    public void deleteCourseWithPrimaryId(int id) {

        courseService.deleteCourseWtihId(id);
    }

    public void uptadeCourse(Course course , int id){

        courseService.uptadeOnDatabese(course,id);
    }

    public List<Student> getCourseStudentList(Course course) {

        return courseService.getCourseStudentList(course);
    }
}
