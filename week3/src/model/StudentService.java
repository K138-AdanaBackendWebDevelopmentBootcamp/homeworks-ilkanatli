package com.proje.service;

import com.proje.model.api.request.StudentCreateRequest;
import com.proje.model.api.request.StudentUpdateRequest;
import com.proje.model.api.response.StudentResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<StudentResponse> findStudents();

    StudentResponse findStudentById(Long id);

    StudentResponse create(StudentCreateRequest request);

    StudentResponse update(StudentUpdateRequest request);

    void deleteById(Long id);
}