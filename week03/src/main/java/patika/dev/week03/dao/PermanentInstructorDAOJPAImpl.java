package patika.dev.week03.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import patika.dev.week03.dao.Interface.IInstructorDAO;
import patika.dev.week03.models.Instructor;

import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class PermanentInstructorDAOJPAImpl implements IInstructorDAO<Instructor> {

    EntityManager entityManager;
    @Autowired
    public PermanentInstructorDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }




    @Override
    @Transactional(readOnly = true)
    public List<Instructor> findAll() {
        return entityManager.createQuery("FROM Instructor" , Instructor.class).getResultList();
    }

    @Override
    @Transactional (readOnly = true)
    public Instructor findById(int id) {
        return null;
    }

    @Override
    @Transactional (readOnly = true)
    public Instructor save(Instructor instructor) {
        return entityManager.merge(instructor);
    }

    @Override
    @Transactional (readOnly = true)
    public void deleteById(int id) {

    }

    @Override
    @Transactional (readOnly = true)
    public Instructor uptadeOnDatabese(Instructor instructor) {
        return null;
    }
}
