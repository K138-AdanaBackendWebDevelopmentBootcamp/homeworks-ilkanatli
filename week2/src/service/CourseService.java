package service;

import models.Course;
import models.Student;
import repository.ICourseRepository;
import repository.ICrudRepository;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseService implements ICrudRepository<Course> , ICourseRepository {

    EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Course> findAll() {
        List<Course> courseList = entityManager.createQuery("SELECT c FROM Course c" , Course.class).getResultList();
        return courseList;

    }

    @Override
    public Course findById(int id) {
        Course course = entityManager.find(Course.class , id);
        return course;
    }

    @Override
    public void saveDatabase(Course course) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
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
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
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
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }

    @Override
    public void uptadeOnDatabese(Course course, int id) {
        try {
            entityManager.getTransaction().begin();

            entityManager.merge(course);


            entityManager.getTransaction().commit();
            System.out.println("Uptade...");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }

    @Override
    public void deleteCourseWtihId(int id) {
        try {
            entityManager.getTransaction().begin();

            Course foundCourse =entityManager.createQuery("SELECT c FROM Course c  WHERE c.id =:courseid",Course.class)
                    .setParameter("courseid",id )
                    .getSingleResult();

            entityManager.remove(foundCourse);
            entityManager.getTransaction().commit();
            System.out.println("Deleted...");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }

    @Override
    public List<Student> getCourseStudentList(Course course) {
        Course foundCourse = entityManager.find(Course.class , course.getId());
        return foundCourse.getStudentList();
    }
}