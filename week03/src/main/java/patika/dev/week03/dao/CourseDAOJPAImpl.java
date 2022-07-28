package patika.dev.week03.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import patika.dev.week03.dao.Interface.ICourseDAO;
import patika.dev.week03.models.Course;

import javax.persistence.EntityManager;

import java.util.List;
@Repository
public class CourseDAOJPAImpl implements ICourseDAO<Course> {

    EntityManager entityManager;

    @Autowired
    public CourseDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional (readOnly = true)
    public List<Course> findAll() {

        return entityManager.createQuery("FROM Course " , Course.class).getResultList();
    }

    @Override
    @Transactional (readOnly = true)
    public Course findById(int id) {

        return null;
    }

    @Override
    @Transactional (readOnly = true)
    public Course save(Course course) {

        return entityManager.merge(course);
    }

    @Override
    @Transactional (readOnly = true)
    public void deleteById(int id) {

    }

    @Override
    @Transactional (readOnly = true)
    public Course uptadeOnDatabese(Course course) {

        return null;
    }
}