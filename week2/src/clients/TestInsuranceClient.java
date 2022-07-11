package clients;

import models.*;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;

public class TestInsuranceClient {
    public static void main(String[] args) {

        EntityManager em = EntityManagerUtils.buildSessionFactory();

        Course course = new Course("Math",90);

        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
        em.clear();
        em.close();
    }
}
