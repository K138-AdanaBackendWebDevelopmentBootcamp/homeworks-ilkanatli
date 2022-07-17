package com.proje.repository.course;

import com.proje.model.entity.Course;
import com.proje.model.entity.Student;
import com.proje.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course> {

    List<Student> findStudentsByCourseId(Long id);

    List<Course> findGreatCreditScore(int creditScore);

    List<Course> findCoursesByInstructorId(Long instructorId);

    List<Course> findBetweenCreditScore(int minCreditScore, int maxCreditScore);

    List<Course> findOrderByCourseCreditScore();
}