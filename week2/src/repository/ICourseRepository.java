package repository;
import models.Course;
import models.Student;

import java.util.List;

public interface ICourseRepository {
    void deleteCourseWtihId(int id);

    List<Student> getCourseStudentList(Course course);
}
