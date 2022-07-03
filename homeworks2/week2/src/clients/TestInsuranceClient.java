package clients;

import controller.CourseController;
import models.*;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;

public class TestInsuranceClient {
    public static void main(String[] args) {

        CourseController courseController = new CourseController();
    }
    private static void saveTestData() {


        Course course1 = new Course("Mathematics",90);
        Course course2 = new Course("Chemical",70);
        Course course3 = new Course("English",45);
        Course course4 = new Course("Geography",75);
        Course course5 = new Course("Physics",88);

        Student student1 = new Student("Ahmet","Elazığ","Male", LocalDate.of(1997, Month.APRIL, 11));
        Student student2 = new Student("Berk","Malatya","Male",LocalDate.of(1999, Month.MAY, 12));
        Student student3 = new Student("Cihan","İzmir","Male",LocalDate.of(2000, Month.JUNE, 1));
        Student student4 = new Student("Gizem","Adana","Female",LocalDate.of(1998, Month.JULY, 2));
        Student student5 = new Student("Zeynep","Manisa","Female",LocalDate.of(1995, Month.SEPTEMBER, 22));


        Instructor visitingResearcher1 = new VisitingResearcher("Ali","Adana","05551231245",8500);
        Instructor permanentTeacher1 = new PermanentTeacher("Hakan","Muğla","05321231245",10000);
        Instructor permanentTeacher2 = new PermanentTeacher("Leyla","Aydın","05411231245",7500);

        course1.setInstructor(permanentTeacher1);
        course2.setInstructor(permanentTeacher2);
        course3.setInstructor(visitingResearcher1);
        course4.setInstructor(visitingResearcher1);
        course5.setInstructor(permanentTeacher2);


        permanentTeacher1.getCourseList().add(course1);
        permanentTeacher2.getCourseList().add(course2);
        visitingResearcher1.getCourseList().add(course3);
        visitingResearcher1.getCourseList().add(course4);
        visitingResearcher1.getCourseList().add(course5);

        course1.getStudentList().add(student1);
        course1.getStudentList().add(student2);
        course1.getStudentList().add(student3);
        course2.getStudentList().add(student4);
        course3.getStudentList().add(student2);
        course3.getStudentList().add(student1);
        course4.getStudentList().add(student5);
        course4.getStudentList().add(student4);
        course5.getStudentList().add(student1);

        student1.getCourseList().add(course1);
        student1.getCourseList().add(course3);
        student1.getCourseList().add(course5);
        student2.getCourseList().add(course1);
        student2.getCourseList().add(course3);
        student3.getCourseList().add(course1);
        student4.getCourseList().add(course2);
        student4.getCourseList().add(course4);
        student5.getCourseList().add(course5);

        EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            entityManager.getTransaction().begin();

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

            entityManager.persist(permanentTeacher1);

            entityManager.persist(visitingResearcher1);
            entityManager.persist(visitingResearcher1);

            entityManager.getTransaction().commit();

        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }

    }
}
