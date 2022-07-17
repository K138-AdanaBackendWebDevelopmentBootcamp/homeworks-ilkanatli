package com.proje.service.implementation;

import com.proje.mapper.InstructorResponseMapper;
import com.proje.model.entity.Course;
import com.proje.model.entity.Instructor;
import com.proje.model.entity.PermanentInstructor;
import com.proje.model.entity.VisitingResearcher;
import com.proje.model.api.request.InstructorUpdateRequest;
import com.proje.model.api.request.PermanentInstructorCreateRequest;
import com.proje.model.api.request.VisitingResearcherCreateRequest;
import com.proje.model.api.response.InstructorResponse;
import com.proje.model.exceptions.NotFoundException;
import com.proje.repository.course.CourseRepository;
import com.proje.repository.instructor.InstructorRepository;
import com.proje.service.InstructorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final CourseRepository courseRepository;
    private final InstructorResponseMapper instructorResponseMapper;

    public InstructorServiceImpl(InstructorRepository instructorRepository, CourseRepository courseRepository, InstructorResponseMapper instructorResponseMapper) {
        this.instructorRepository = instructorRepository;
        this.courseRepository = courseRepository;
        this.instructorResponseMapper = instructorResponseMapper;
    }


    @Override
    public List<InstructorResponse> findInstructors() {
        return instructorRepository.findAll()
                .stream()
                .map(instructorResponseMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public InstructorResponse findInstructorById(Long id) {
        Instructor instructor = instructorRepository.findById(id);
        return instructorResponseMapper.map(instructor);
    }

    @Override
    public InstructorResponse createPermanentInstructor(PermanentInstructorCreateRequest request) {
        PermanentInstructor permanentInstructor = new PermanentInstructor();
        permanentInstructor.setName(request.getName());
        permanentInstructor.setAddress(request.getAddress());
        permanentInstructor.setPhoneNumber(request.getPhoneNumber());
        permanentInstructor.setFixedSalary(request.getFixedSalary());

        Instructor createdInstructor = instructorRepository.save(permanentInstructor);
        return instructorResponseMapper.map(createdInstructor);
    }

    @Override
    public InstructorResponse createVisitingResearcher(VisitingResearcherCreateRequest request) {
        VisitingResearcher visitingResearcher = new VisitingResearcher();
        visitingResearcher.setName(request.getName());
        visitingResearcher.setAddress(request.getAddress());
        visitingResearcher.setPhoneNumber(request.getPhoneNumber());
        visitingResearcher.setHourlySalary(request.getHourlySalary());

        Instructor createdInstructor = instructorRepository.save(visitingResearcher);
        return instructorResponseMapper.map(createdInstructor);
    }

    @Override
    public InstructorResponse update(InstructorUpdateRequest request) {
        Instructor instructor = instructorRepository.findById(request.getId());
        if (instructor == null) {
            throw new NotFoundException("Instructor not found by id: " + request.getId());
        }
        instructor.setName(request.getName());
        instructor.setAddress(request.getAddress());
        instructor.setPhoneNumber(request.getPhoneNumber());

        Instructor updatedInstructor= instructorRepository.save(instructor);
        return instructorResponseMapper.map(updatedInstructor);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        List<Course> courses = courseRepository.findCoursesByInstructorId(id);
        for (Course course : courses) {
            course.setInstructor(null);
            courseRepository.save(course);
        }
        instructorRepository.deleteById(id);
    }
}