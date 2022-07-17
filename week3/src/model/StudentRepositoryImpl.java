package com.proje.repository.student;

import com.proje.model.entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public StudentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Override
    public Student findById(Long id) {
        return entityManager.createQuery("SELECT s FROM Student s WHERE s.id =:id", Student.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    @Transactional
    public Student save(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    @Transactional
    public void delete(Student student) {
        entityManager.remove(student);
    }

    @Override
    public void deleteById(Long id) {
        Student foundStudent = findById(id);
        entityManager.remove(foundStudent);
    }

    @Override
    @Transactional
    public Student update(Student student) {
        entityManager.merge(student);
        return student;
    }
}