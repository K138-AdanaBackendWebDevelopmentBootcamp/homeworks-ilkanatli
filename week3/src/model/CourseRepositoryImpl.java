package com.proje.repository.course;

import com.proje.model.entity.Course;
import com.proje.model.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public CourseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> findAll() {
        return entityManager.createQuery("SELECT c FROM Course c", Course.class).getResultList();
    }

    @Override
    public Course findById(Long id) {
        return entityManager.createQuery("SELECT c FROM Course c WHERE c.id =:id", Course.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    @Transactional
    public Course save(Course course) {
        entityManager.persist(course);
        return course;
    }

    @Override
    @Transactional
    public void delete(Course course) {
        Course foundCourse = findById(course.getId());
        if (foundCourse == null) {
            return;
        }
        entityManager.remove(foundCourse);
    }

    @Override
    public void deleteById(Long id) {
        Course foundCourse = findById(id);
        if (foundCourse == null) {
            return;
        }
        entityManager.remove(foundCourse);
    }

    @Override
    @Transactional
    public Course update(Course course) {
        entityManager.merge(course);
        return course;
    }

    @Override
    @Transactional
    public List<Student> findStudentsByCourseId(Long id) {
        Course course = findById(id);
        if (course == null) {
            return Collections.emptyList();
        }
        return course.getStudents();
    }

    @Override
    public List<Course> findCoursesByInstructorId(Long instructorId) {
        return entityManager.createQuery("SELECT c FROM Course c WHERE c.instructor.id = :instructorId", Course.class)
                .setParameter("instructorId", instructorId).getResultList();
    }

    @Override
    public List<Course> findGreatCreditScore(int creditScore) {
        return entityManager.createQuery("SELECT c FROM Course c WHERE c.creditScore > :creditScore", Course.class)
                .setParameter("creditScore", creditScore).getResultList();
    }

    @Override
    public List<Course> findBetweenCreditScore(int minCreditScore, int maxCreditScore) {
        return entityManager.createQuery("SELECT c FROM Course c WHERE c.creditScore BETWEEN :minCreditScore AND :maxCreditScore", Course.class)
                .setParameter("minCreditScore", minCreditScore)
                .setParameter("maxCreditScore", maxCreditScore)
                .getResultList();
    }

    @Override
    public List<Course> findOrderByCourseCreditScore() {
        return entityManager.createQuery("SELECT c FROM Course c ORDER BY c.creditScore ASC", Course.class).getResultList();
    }
}