package com.proje.mapper;

import com.proje.model.entity.Student;
import com.proje.model.api.response.StudentResponse;
import org.springframework.stereotype.Component;

@Component
public class StudentResponseMapper {

    public StudentResponse map(Student student){
        return new StudentResponse(student.getId(), student.getName(), student.getBirtOfDate(), student.getAddress(), student.getGender());
    }
}