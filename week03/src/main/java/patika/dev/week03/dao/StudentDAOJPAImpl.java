package patika.dev.week03.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import patika.dev.week03.dao.Interface.IStudentDAO;
import patika.dev.week03.models.Student;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class StudentDAOJPAImpl implements IStudentDAO<Student> {

    EntityManager entityManager;
    @Autowired
    public StudentDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public StudentDAOJPAImpl() {
    }

    @Override
    @Transactional (readOnly = true)
    public List<Student> findAll() {
        return entityManager.createQuery("From Student" , Student.class).getResultList();
    }

    @Override
    @Transactional (readOnly = true)
    public Student findById(int id) {
        return null;
    }

    @Override
    @Transactional (readOnly = true)
    public Student save(Student student) {
        return entityManager.merge(student);
    }

    @Override
    @Transactional (readOnly = true)
    public void deleteById(int id) {

    }

    @Override
    @Transactional (readOnly = true)
    public Student uptadeOnDatabese(Student student) {
        return null;
    }
}
