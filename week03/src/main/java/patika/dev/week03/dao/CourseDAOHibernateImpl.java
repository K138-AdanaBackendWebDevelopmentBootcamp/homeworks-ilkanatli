package patika.dev.week03.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import patika.dev.week03.dao.Interface.ICourseDAO;
import patika.dev.week03.models.Course;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseDAOHibernateImpl implements ICourseDAO<Course> {

    EntityManager entityManager;
    @Autowired
    public CourseDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> findAll() {
        Session session = entityManager.unwrap(Session.class);

        return session.createQuery("from Course" , Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        return null;
    }

    @Override
    public Course save(Course object) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Course uptadeOnDatabese(Course object) {
        return null;
    }
}