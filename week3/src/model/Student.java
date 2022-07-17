package com.proje.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "birt_of_date")
    private LocalDate birtOfDate;

    private String address;

    private String gender;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "students")
    private List<Course> courses = new ArrayList<>();

    public Student() {

    }

    public Student(String name, LocalDate birtOfDate, String address, String gender) {
        this.name = name;
        this.birtOfDate = birtOfDate;
        this.address = address;
        this.gender = gender;
    }

    public void remove(Course course) {
        this.courses.remove(course);
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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}