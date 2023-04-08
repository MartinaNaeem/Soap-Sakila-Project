package gov.iti.jets.filmslibrary.repository;

import gov.iti.jets.filmslibrary.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import gov.iti.jets.filmslibrary.model.ActorInfo;

import java.util.Date;
import java.util.List;


public class ActorFilmsRepo {


    public ActorInfo getFilmsOFAnActor(short id){
        EntityManager entityManager = EntityFactory.emf.createEntityManager();
        Query query = entityManager.createQuery("FROM ActorInfo a WHERE a.id = :id");
        query.setParameter("id",id);
        ActorInfo actorInfo = (ActorInfo)query.getSingleResult();
        entityManager.close();
        return actorInfo;
    }

    public List<ActorInfo> getFilmsOfAllActors(){
        EntityManager entityManager = EntityFactory.emf.createEntityManager();
        Query query = entityManager.createQuery("FROM ActorInfo");
        List<ActorInfo> actorInfoList = query.getResultList();
        entityManager.close();
        return actorInfoList;
    }


    public boolean addExistingFilmToAnExistingActor(short filmId, short actorId) {
        EntityManager entityManager = EntityFactory.emf.createEntityManager();
        entityManager.getTransaction().begin();

        FilmActor filmActor = new FilmActor();
        filmActor.setActor(entityManager.find(Actor.class, actorId));
        filmActor.setFilm(entityManager.find(Film.class, filmId));
        filmActor.setLastUpdate(new Date());

        FilmActorPK filmActorPK = new FilmActorPK();
        filmActorPK.setActorId(actorId);
        filmActorPK.setFilmId(filmId);

        filmActor.setFilmActorPK(filmActorPK);

        entityManager.persist(filmActor);

        entityManager.getTransaction().commit();
        entityManager.close();
        return true;

    }

    public int removeFilmOfAnActor(short filmId, short actorId) {
        EntityManager entityManager = EntityFactory.emf.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("Delete from FilmActor a where a.actor.actorId = :actorId  and a.film.filmId = :filmId");
        query.setParameter("actorId", actorId);
        query.setParameter("filmId", filmId);
        int effectedRows = query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        return effectedRows;
    }


    public boolean removeAllFilmsActors() {
        EntityManager entityManager = EntityFactory.emf.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("Delete from FilmActor");
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }
}
