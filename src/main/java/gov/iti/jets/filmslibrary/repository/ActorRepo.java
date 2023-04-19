package gov.iti.jets.filmslibrary.repository;

import gov.iti.jets.filmslibrary.dtos.actorDtos.ActorGetterDto;
import gov.iti.jets.filmslibrary.dtos.actorDtos.ActorSetterDto;
import gov.iti.jets.filmslibrary.mappers.ActorMapper;
import gov.iti.jets.filmslibrary.model.Actor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActorRepo {

    ActorMapper actorMapper;

    public ActorRepo() {
        actorMapper = new ActorMapper();
    }

    public List<ActorGetterDto> getAllActors() {
        EntityManager em = EntityFactory.emf.createEntityManager();
        List<Actor> actorList = em.createQuery("from Actor").getResultList();
        List<ActorGetterDto> actorGetterDtoList = new ArrayList<>();
        for (Actor actor : actorList) {
            actorGetterDtoList.add(actorMapper.toActorGetter(actor));
        }
        em.close();
        return actorGetterDtoList;
    }

    public boolean addActor(ActorSetterDto actorSetterDto) {
        EntityManager em = EntityFactory.emf.createEntityManager();
        em.getTransaction().begin();
        Actor actor = new Actor();
        actor.setFirstName(actorSetterDto.getFirstName());
        actor.setLastUpdate(new Date());
        actor.setLastName(actorSetterDto.getLastName());
        em.persist(actor);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    public boolean deleteActor(Short id) {
        EntityManager em = EntityFactory.emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("delete from Actor a where a.actorId =:id");
        q.setParameter("id", id);
        q.executeUpdate();
        em.getTransaction().commit();
        em.close();
        return true;
    }

    public boolean updateActor(ActorSetterDto actorSetterDto) {
        EntityManager em = EntityFactory.emf.createEntityManager();
        em.getTransaction().begin();
        Actor actor = new Actor();
        actor.setLastUpdate(new Date());
        actor.setActorId(actorSetterDto.getId());
        actor.setFirstName(actorSetterDto.getFirstName());
        actor.setLastName(actorSetterDto.getLastName());
        em.merge(actor);
        em.getTransaction().commit();
        em.close();
        return true;
    }
}
