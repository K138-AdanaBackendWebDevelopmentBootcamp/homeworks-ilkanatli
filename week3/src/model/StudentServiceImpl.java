package com.proje.service.implementation;

import com.proje.mapper.StudentResponseMapper;
import com.proje.model.entity.Course;
import com.proje.model.entity.Student;
import com.proje.model.api.request.StudentCreateRequest;
import com.proje.model.api.request.StudentUpdateRequest;
import com.proje.model.api.response.StudentResponse;
import com.proje.model.exceptions.NotFoundException;
import com.proje.repository.course.CourseRepository;
import com.proje.repository.student.StudentRepository;
import com.proje.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentResponseMapper studentResponseMapper;

    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository, StudentResponseMapper studentResponseMapper) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.studentResponseMapper = studentResponseMapper;
    }

    @Override
    public List<StudentResponse> findStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentResponseMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponse findStudentById(Long id) {
        Student student = studentRepository.findById(id);
        return studentResponseMapper.map(student);
    }

    @Override
    public StudentResponse create(StudentCreateRequest request) {
        Student student = new Student();
        student.setAddress(request.getAddress());
        student.setName(request.getName());
        student.setGender(request.getGender());
        student.setBirtOfDate(request.getBirtOfDate());

        Student createdStudent = studentRepository.save(student);
        return studentResponseMapper.map(createdStudent);
    }

    @Override
    public StudentResponse update(StudentUpdateRequest request) {
        Student student = studentRepository.findById(request.getId());
        if (student == null) {
            throw new NotFoundException("Student not found by id: " + request.getId());
        }
        student.setAddress(request.getAddress());
        student.setName(request.getName());
        student.setGender(request.getGender());
        student.setBirtOfDate(request.getBirtOfDate());

        Student updatedStudent = studentRepository.save(student);
        return studentResponseMapper.map(updatedStudent);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Student student = studentRepository.findById(id);
        List<Course> courses = student.getCourses();
        for (Course course : courses) {
            course.removeStudent(student);
            courseRepository.save(course);
        }
        studentRepository.deleteById(id);
    }
}