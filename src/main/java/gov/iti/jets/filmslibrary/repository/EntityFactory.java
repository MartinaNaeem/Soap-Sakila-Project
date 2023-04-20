package gov.iti.jets.filmslibrary.repository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Synchronized;

public class EntityFactory {
    private volatile static EntityFactory instance;

    private EntityFactory() {
    }

    public static EntityFactory getInstance() {
        if (instance == null) {
            synchronized (EntityFactory.class) {
                if (instance == null) {
                    instance = new EntityFactory();
                }
            }
        }
        return instance;
    }

    public EntityManagerFactory getEmf() {
        return Persistence.createEntityManagerFactory("sakila");
    }


}
