package gov.iti.jets.filmslibrary.repository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Synchronized;

public class EntityFactory {
    private volatile static EntityManagerFactory emf = null;

    public static EntityManagerFactory getEmf() {
        if (emf == null) {
            synchronized (EntityManagerFactory.class) {
                if (emf == null) {
                    emf = Persistence.createEntityManagerFactory("sakila");                }
            }
        }
        return emf;
    }


}
