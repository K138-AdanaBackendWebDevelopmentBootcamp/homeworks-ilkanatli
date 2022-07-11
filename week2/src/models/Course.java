package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity

public class Course {

    @Id
    @GeneratedValue(generator = "course", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "course", sequenceName = "COURSE_SEQ_ID")

    private int id;
    private  String courseName;
    private  String courseCode;
    private int creditScore;


    public Course(String courseName, String courseCode, int creditScore) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditScore = creditScore;
    }

    public Course() {
    }

    public Course(String courseName, int creditScore) {
        this.courseName = courseName;
        this.creditScore = creditScore;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Instructor.class)
    private Instructor instructor;

    public Course(String courseName, String courseCode, int creditScore, Instructor instructor, List<Student> studentList) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditScore = creditScore;
        this.instructor = instructor;
        this.studentList = studentList;
    }

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Student.class,cascade = CascadeType.ALL, mappedBy = "courseList")
    private List<Student> studentList = new ArrayList<>();

    public List<Student> getStudentList() {
        return studentList;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseCode.equals(course.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", creditScore=" + creditScore +
                '}';
    }

    public void setInstructor(Instructor visitingResearcher1) {
    }
}
