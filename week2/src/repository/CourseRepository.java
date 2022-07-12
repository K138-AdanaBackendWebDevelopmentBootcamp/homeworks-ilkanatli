package repository;

import models.Course;
import models.Instructor;
import models.Student;

import java.util.List;
public interface CourseRepository {

    void deletebyCourseId(Long id);
    Instructor getInstructor(Course course);
    List<Student> getStudentList(Course course);
}

