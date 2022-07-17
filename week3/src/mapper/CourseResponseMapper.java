package com.proje.mapper;

import com.proje.model.entity.Course;
import com.proje.model.api.response.CourseResponse;
import com.proje.model.api.response.InstructorResponse;
import org.springframework.stereotype.Component;

@Component
public class CourseResponseMapper {

    private final InstructorResponseMapper instructorResponseMapper;

    public CourseResponseMapper(InstructorResponseMapper instructorResponseMapper) {
        this.instructorResponseMapper = instructorResponseMapper;
    }

    public CourseResponse map(Course course){
        if (course.getInstructor() == null){
            return new CourseResponse(course.getId(), course.getName(), course.getCreditScore());
        }
        InstructorResponse instructorResponse = instructorResponseMapper.map(course.getInstructor());
        return new CourseResponse(course.getId(), course.getName(), course.getCreditScore(), instructorResponse);
    }
}