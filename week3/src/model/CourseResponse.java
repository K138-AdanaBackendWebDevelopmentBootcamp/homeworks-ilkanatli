package com.proje.model.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseResponse {

    private Long id;

    private String name;

    private int creditScore;

    private InstructorResponse instructor;

    public CourseResponse(Long id, String name, int creditScore) {
        this.id = id;
        this.name = name;
        this.creditScore = creditScore;
    }

    public CourseResponse(Long id, String name, int creditScore, InstructorResponse instructor) {
        this.id = id;
        this.name = name;
        this.creditScore = creditScore;
        this.instructor = instructor;
    }

    public InstructorResponse getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorResponse instructor) {
        this.instructor = instructor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }
}
