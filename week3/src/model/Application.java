package com.proje;

import com.proje.model.entity.Course;
import com.proje.model.entity.PermanentInstructor;
import com.proje.model.entity.Student;
import com.proje.model.entity.VisitingResearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        //saveTestData();
    }

    private void saveTestData() {

        Course course1 = new Course("Mathematics", 80);
        Course course2 = new Course("English", 50);
        Course course3 = new Course("Art", 30);
        Course course4 = new Course("Physics", 60);
        Course course5 = new Course("Turkish", 70);

        Student student1 = new Student("Hakan", LocalDate.of(1999, Month.APRIL, 12), "Adana", "male");
        Student student2 = new Student("Oğuzhan", LocalDate.of(2002, Month.MARCH, 05), "Mersin", "male");
        Student student3 = new Student("Ayse", LocalDate.of(1995, Month.JANUARY, 15), "Istanbul", "female");
        Student student4 = new Student("Fatma", LocalDate.of(1996, Month.DECEMBER, 28), "Bursa", "female");
        Student student5 = new Student("Burak", LocalDate.of(2005, Month.MARCH, 12), "Adana", "male");

        PermanentInstructor permanentInstructor1 = new PermanentInstructor("Ali", "Adana", "55555555555l", 9500);

        VisitingResearcher visitingResearcher1 = new VisitingResearcher("Rümeysa", "Bursa", "2222222l", 65.9);
        VisitingResearcher visitingResearcher2 = new VisitingResearcher("Buse", "Istanbul", "1111111l", 92.4);

        course1.setInstructor(permanentInstructor1);
        course2.setInstructor(permanentInstructor1);
        course3.setInstructor(visitingResearcher1);
        course4.setInstructor(visitingResearcher2);
        course5.setInstructor(visitingResearcher2);

        course1.getStudents().add(student1);
        course1.getStudents().add(student2);
        course1.getStudents().add(student3);
        course2.getStudents().add(student4);
        course3.getStudents().add(student2);
        course3.getStudents().add(student1);
        course4.getStudents().add(student5);
        course4.getStudents().add(student4);
        course5.getStudents().add(student1);

        entityManager.persist(course1);
        entityManager.persist(course2);
        entityManager.persist(course3);
        entityManager.persist(course4);
        entityManager.persist(course5);

        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);
        entityManager.persist(student4);
        entityManager.persist(student5);

        entityManager.persist(permanentInstructor1);

        entityManager.persist(visitingResearcher1);
        entityManager.persist(visitingResearcher2);
    }
}