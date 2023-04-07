package gov.iti.jets.filmslibrary.repository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityFactory {
    public static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("sakila");

}
