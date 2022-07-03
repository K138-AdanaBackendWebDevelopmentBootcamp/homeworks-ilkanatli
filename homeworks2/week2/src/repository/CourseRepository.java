package repository;

import models.Course;
import models.Student;

import java.util.List;

public interface CourseRepository {

    List<Student> getCourseStudentList(Course course);

    List<Course> findGreatCreditScore(int creditScore);

    List<Course> findBetweenCreditScore(int minCreditScore, int maxCreditScore);

    List<Course> findOrderByCourseCreditScore();
}