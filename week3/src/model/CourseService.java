package com.proje.service;

import com.proje.model.api.request.AddStudentToCourseRequest;
import com.proje.model.api.response.CourseResponse;
import com.proje.model.api.response.StudentResponse;
import com.proje.model.api.request.CourseCreateRequest;
import com.proje.model.api.request.CourseUpdateRequest;

import java.util.List;

public interface CourseService {

    CourseResponse findById(Long id);

    CourseResponse create(CourseCreateRequest request);

    void deleteById(Long id);

    CourseResponse update(CourseUpdateRequest request);

    List<StudentResponse> findStudentsByCourseId(Long id);

    List<CourseResponse> findCourses();

    List<CourseResponse> findCoursesByGreatCreditScore(int creditScore);

    List<CourseResponse> findCoursesByBetweenCreditScore(int minCreditScore, int maxCreditScore);

    List<CourseResponse> findCoursesByOrderedCreditScore();

    void addStudentToCourse(Long id, AddStudentToCourseRequest request);

    void deleteStudentInCourse(Long id, Long studentId);
}