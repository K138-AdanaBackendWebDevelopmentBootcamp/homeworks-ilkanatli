package models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity

public class Student {

    @Id
    @GeneratedValue(generator = "student", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "student", sequenceName = "STUDENT_SEQ_ID")
    private int id;

    private String name;
    private LocalDate birthdate;
    private  String address;
    private String gender;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Course.class, cascade = CascadeType.ALL)
    private List<Course> courseList = new ArrayList<>();

    public List<Course> getCourseList() {
        return courseList;
    }

    public Student(String name, LocalDate birthdate, String address, String gender, List<Course> courseList) {
        this.name = name;
        this.birthdate = birthdate;
        this.address = address;
        this.gender = gender;
        this.courseList = courseList;
    }

    public Student(String name, LocalDate birthdate, String address, String gender) {
        this.name = name;
        this.birthdate = birthdate;
        this.address = address;
        this.gender = gender;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }


    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
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

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(birthdate, student.birthdate) && Objects.equals(address, student.address) && Objects.equals(gender, student.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthdate, address, gender);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
