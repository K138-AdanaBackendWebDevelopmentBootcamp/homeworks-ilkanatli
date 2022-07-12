package clients;

import controller.CourseController;
import models.*;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class TestInsuranceClient {
    public static void main(String[] args) {

        EntityManager em = EntityManagerUtils.buildSessionFactory();

        Course course = new Course("Math",90);
        Course course1 = new Course("English","E101",80);
        Course course2 = new Course("Chemical","C101",40);
        Course course3 = new Course("Art","A101",50);
        Course course4 = new Course("Physics","P101",70);
        Course course5 = new Course("Turkish","T101",80);

        List<Course> courseList = new ArrayList<>();
        courseList.add(course);
        courseList.add(course2);
        courseList.add(course3);
        courseList.add(course4);
        courseList.add(course5);

        VisitingResearcher visitingResearcher = new VisitingResearcher("Ahmet Demiz","Adana","05423214556",10000);
        VisitingResearcher visitingResearcher1 = new VisitingResearcher("Banu Kaya","Ankara","5531231212",15000);
        VisitingResearcher visitingResearcher2 = new VisitingResearcher("Nesrin Turk","Istanbul","53298787878",14000);
        VisitingResearcher visitingResearcher3 = new VisitingResearcher("Osman Ay","Canakkale","5549874545",16000);
        PermanentInstructor permanentInstructor = new PermanentInstructor("Ahmet Sansli","Mardin","5556549898",12500);


        course1.setInstructor(visitingResearcher);
        course2.setInstructor(visitingResearcher1);
        course3.setInstructor(visitingResearcher2);
        course4.setInstructor(visitingResearcher3);
        course5.setInstructor(visitingResearcher3);



        CourseController courseController = new CourseController();
        courseController.saveCourse(course);
        courseController.saveCourse(course1);
        courseController.saveCourse(course2);
        courseController.saveCourse(course3);
        courseController.saveCourse(course4);
        courseController.saveCourse(course5);

    }
}
