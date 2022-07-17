package com.proje.model.api.request;

public class VisitingResearcherCreateRequest extends InstructorCreateRequest{

    private double hourlySalary;

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }
}
