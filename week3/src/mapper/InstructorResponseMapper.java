package com.proje.mapper;

import com.proje.model.entity.Instructor;
import com.proje.model.entity.PermanentInstructor;
import com.proje.model.entity.VisitingResearcher;
import com.proje.model.api.response.InstructorResponse;
import org.springframework.stereotype.Component;

@Component
public class InstructorResponseMapper {

    public InstructorResponse map(Instructor instructor) {
        InstructorResponse instructorResponse = new InstructorResponse(instructor.getId(), instructor.getName(), instructor.getAddress(), instructor.getPhoneNumber());
        if (instructor instanceof PermanentInstructor) {
            PermanentInstructor permanentInstructor = (PermanentInstructor) instructor;
            instructorResponse.setType("Permanent");
            instructorResponse.setFixedSalary(permanentInstructor.getFixedSalary());
        } else if (instructor instanceof VisitingResearcher){
            VisitingResearcher visitingResearcher = (VisitingResearcher) instructor;
            instructorResponse.setType("Visiting");
            instructorResponse.setHourlySalary(visitingResearcher.getHourlySalary());
        }
        return instructorResponse;
    }
}