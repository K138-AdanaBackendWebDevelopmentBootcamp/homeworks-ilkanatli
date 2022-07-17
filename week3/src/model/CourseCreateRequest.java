package com.proje.model.api.request;

import io.swagger.annotations.ApiModelProperty;

public class CourseCreateRequest {

    private String courseName;

    @ApiModelProperty(value = "Bu course'ların credi scoru için kullanılıyor")
    private int creditScore;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }
}