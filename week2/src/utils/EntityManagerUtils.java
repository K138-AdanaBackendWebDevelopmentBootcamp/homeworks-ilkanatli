package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public final class EntityManagerUtils {
    @PersistenceContext
    static EntityManagerFactory emf = null;


    public static EntityManager buildSessionFactory(){
        emf = Persistence.createEntityManagerFactory("mysqlPU");
        return emf.createEntityManager();
    }
    public static void closeEntityManager(EntityManager em){
        em.clear();
        em.close();
        emf.close();
    }

}
