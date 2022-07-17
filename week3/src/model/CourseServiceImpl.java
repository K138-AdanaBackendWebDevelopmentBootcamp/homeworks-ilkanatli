package com.proje.service.implementation;

import com.proje.mapper.CourseResponseMapper;
import com.proje.model.api.request.AddStudentToCourseRequest;
import com.proje.model.entity.Course;
import com.proje.model.api.response.CourseResponse;
import com.proje.model.api.response.StudentResponse;
import com.proje.model.api.request.CourseCreateRequest;
import com.proje.model.api.request.CourseUpdateRequest;
import com.proje.model.entity.Student;
import com.proje.model.exceptions.NotFoundException;
import com.proje.repository.course.CourseRepository;
import com.proje.repository.student.StudentRepository;
import com.proje.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final CourseResponseMapper courseResponseMapper;

    public CourseServiceImpl(CourseRepository courseRepository, StudentRepository studentRepository, CourseResponseMapper courseResponseMapper) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.courseResponseMapper = courseResponseMapper;
    }

    @Override
    public List<CourseResponse> findCourses() {
        return courseRepository.findAll()
                .stream()
                .map(courseResponseMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public CourseResponse findById(Long id) {
        Course course = courseRepository.findById(id);
        return courseResponseMapper.map(course);
    }

    @Override
    public CourseResponse create(CourseCreateRequest request) {
        Course course = new Course();
        course.setName(request.getCourseName());
        course.setCreditScore(request.getCreditScore());
        Course createdCourse = courseRepository.save(course);
        return courseResponseMapper.map(createdCourse);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Course course = courseRepository.findById(id);
        List<Student> students = course.getStudents();
        for (Student student : students) {
            student.remove(course);
            studentRepository.save(student);
        }
        courseRepository.delete(course);
    }

    @Override
    public CourseResponse update(CourseUpdateRequest request) {
        Course course = courseRepository.findById(request.getId());
        if (course == null) {
            throw new NotFoundException("Course not found by id: " + request.getId());
        }
        course.setName(request.getName());
        course.setCreditScore(request.getCreditScore());
        Course updatedCourse = courseRepository.update(course);
        return courseResponseMapper.map(updatedCourse);
    }

    @Override
    @Transactional
    public void addStudentToCourse(Long id, AddStudentToCourseRequest request) {
        Course course = courseRepository.findById(id);
        Student student = studentRepository.findById(request.getStudentId());
        course.addStudent(student);
        courseRepository.save(course);
    }

    @Override
    public void deleteStudentInCourse(Long id, Long studentId) {
        Course course = courseRepository.findById(id);
        Student student = studentRepository.findById(studentId);
        course.removeStudent(student);
        courseRepository.save(course);
    }

    @Override
    public List<StudentResponse> findStudentsByCourseId(Long id) {
        Course course = courseRepository.findById(id);
        return course
                .getStudents()
                .stream()
                .map(student -> new StudentResponse(student.getId(), student.getName(), student.getBirtOfDate(), student.getAddress(), student.getGender()))
                .collect(Collectors.toList());

    }

    @Override
    public List<CourseResponse> findCoursesByGreatCreditScore(int creditScore) {
        return courseRepository.findGreatCreditScore(creditScore)
                .stream()
                .map(courseResponseMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseResponse> findCoursesByBetweenCreditScore(int minCreditScore, int maxCreditScore) {
        return courseRepository.findBetweenCreditScore(minCreditScore, maxCreditScore)
                .stream()
                .map(courseResponseMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseResponse> findCoursesByOrderedCreditScore() {
        return courseRepository.findOrderByCourseCreditScore()
                .stream()
                .map(courseResponseMapper::map)
                .collect(Collectors.toList());
    }
}