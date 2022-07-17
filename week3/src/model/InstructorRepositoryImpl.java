package com.proje.repository.instructor;

import com.proje.model.entity.Instructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class InstructorRepositoryImpl implements InstructorRepository{

    @PersistenceContext
    private final EntityManager entityManager;

    public InstructorRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Instructor> findAll() {
        return entityManager.createQuery("SELECT i FROM Instructor i", Instructor.class).getResultList();
    }

    @Override
    public Instructor findById(Long id) {

        return entityManager.createQuery("SELECT i FROM Instructor i WHERE i.id =:id", Instructor.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        entityManager.persist(instructor);
        return instructor;
    }

    @Override
    @Transactional
    public void delete(Instructor instructor) {
        Instructor foundInstructor = findById(instructor.getId());
        if (foundInstructor == null) {
            return;
        }
        entityManager.remove(foundInstructor);
    }

    @Override
    public void deleteById(Long id) {
        Instructor foundInstructor = findById(id);
        if (foundInstructor == null) {
            return;
        }
        entityManager.remove(foundInstructor);
    }

    @Override
    @Transactional
    public Instructor update(Instructor instructor) {
        entityManager.merge(instructor);
        return instructor;
    }
}