package patika.dev.week03.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



@Entity
public class Course {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    //@JsonIgnore Anatasyon altındakini görünmez yapar.
    private String courseName;
    private String courseCode;
    private int creditScore;

    public Course() {
    }
    @ManyToMany(mappedBy = "courseList" )
    private List<Student> studentList = new ArrayList<>();

    @ManyToOne
    private Instructor instructor;

    public Course(int id, String courseName, String courseCode, int creditScore, List<Student> studentList) {
        this.id = id;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditScore = creditScore;
        this.studentList = studentList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && creditScore == course.creditScore && Objects.equals(courseName, course.courseName) && Objects.equals(courseCode, course.courseCode) && Objects.equals(studentList, course.studentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, courseCode, creditScore, studentList);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", creditScore=" + creditScore +
                ", studentList=" + studentList +
                '}';
    }
}