package service;

import models.Instructor;
import repository.ICrudRepository;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public  class InstructorService implements ICrudRepository<Instructor> {

    EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Instructor> findAll() {

        List<Instructor> instructorList = entityManager.createQuery("SELECT i FROM Instructor i ", Instructor.class).getResultList();
        return instructorList;
    }

    @Override
    public Instructor findById(int id) {
        Instructor instructor = entityManager.find(Instructor.class,id);

        return instructor;
    }



    @Override
    public void saveDatabase(Instructor instructor) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(instructor);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
        }
    }

    @Override
    public void deleteFromDatabase(Instructor object) {

    }

    @Override
    public void deleteFromDatabase(int id) {

    }

    @Override
    public void uptadeOnDatabese(Instructor object, int id) {

    }
}