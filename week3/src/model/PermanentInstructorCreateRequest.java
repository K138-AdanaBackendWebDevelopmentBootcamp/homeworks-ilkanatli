package com.proje.model.api.request;

public class PermanentInstructorCreateRequest extends InstructorCreateRequest{

    private double fixedSalary;

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }
}