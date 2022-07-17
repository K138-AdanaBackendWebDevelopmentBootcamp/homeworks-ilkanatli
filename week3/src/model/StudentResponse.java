package com.proje.model.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponse {

    private Long id;

    private String name;

    private LocalDate birtOfDate;

    private String address;

    private String gender;

    public StudentResponse(Long id, String name, LocalDate birtOfDate, String address, String gender) {
        this.id = id;
        this.name = name;
        this.birtOfDate = birtOfDate;
        this.address = address;
        this.gender = gender;
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

    public LocalDate getBirtOfDate() {
        return birtOfDate;
    }

    public void setBirtOfDate(LocalDate birtOfDate) {
        this.birtOfDate = birtOfDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}