package com.proje.service;

import com.proje.model.api.request.InstructorUpdateRequest;
import com.proje.model.api.request.PermanentInstructorCreateRequest;
import com.proje.model.api.request.VisitingResearcherCreateRequest;
import com.proje.model.api.response.InstructorResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InstructorService{

    List<InstructorResponse> findInstructors();

    InstructorResponse findInstructorById(Long id);

    InstructorResponse createPermanentInstructor(PermanentInstructorCreateRequest request);

    InstructorResponse createVisitingResearcher(VisitingResearcherCreateRequest request);

    InstructorResponse update(InstructorUpdateRequest request);

    void deleteById(Long id);
}