package service;

import models.Course;
import models.Student;
import repository.CourseRepository;
import repository.CrudRepository;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseService implements CrudRepository<Course>, CourseRepository {

    EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Course> findAll() {
        return entityManager.createQuery("FROM Course", Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public void saveToDatabase(Course course) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void deleteFromDatabase(Course course) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(course);
            entityManager.getTransaction().commit();
            System.out.println("Deleted...");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void deleteFromDatabase(int id) {
        try {
            entityManager.getTransaction().begin();
            Course foundCourse = findById(id);
            entityManager.remove(foundCourse);
            entityManager.getTransaction().commit();
            System.out.println("Deleted...");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void updateOnDatabase(Course course) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(course);
            entityManager.getTransaction().commit();
            System.out.println("Deleted...");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<Student> getCourseStudentList(Course course) {
        Course foundCourse = entityManager.find(Course.class, course.getCourseCode());
        return foundCourse.getStudentList();
    }

    @Override
    public List<Course> findGreatCreditScore(int creditScore) {
        return entityManager.createQuery("FROM Course c WHERE c.creditScore > :creditScore", Course.class)
                .setParameter("creditScore", creditScore).getResultList();
    }

    @Override
    public List<Course> findBetweenCreditScore(int minCreditScore, int maxCreditScore) {
        return entityManager.createQuery("FROM Course c WHERE c.creditScore BETWEEN :minCreditScore AND :maxCreditScore", Course.class)
                .setParameter("minCreditScore", minCreditScore)
                .setParameter("maxCreditScore", maxCreditScore)
                .getResultList();
    }

    @Override
    public List<Course> findOrderByCourseCreditScore() {
        return entityManager.createQuery("FROM Course c ORDER BY c.creditScore ASC", Course.class).getResultList();


    }
}